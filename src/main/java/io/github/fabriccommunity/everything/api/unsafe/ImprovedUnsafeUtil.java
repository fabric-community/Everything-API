/*
 *     Copyright (C) 2020 Fabric Community
 *
 *     This program is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU Lesser General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     This program is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU Lesser General Public License for more details.
 *
 *     You should have received a copy of the GNU Lesser General Public License
 *     along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

package io.github.fabriccommunity.everything.api.unsafe;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

public class ImprovedUnsafeUtil {
    public static Unsafe UNSAFE_PLS_NO_TOUCHY;
    public static void initialize() throws Exception {
        Field f = Unsafe.class.getDeclaredField("theUnsafe");
        f.setAccessible(true);
        UNSAFE_PLS_NO_TOUCHY = (Unsafe) f.get(null);
    }

    // this is private so no one uses unsafe
    private static Unsafe getUnsafe() {
        return UNSAFE_PLS_NO_TOUCHY;
    }

    public static class ConstructorUtil extends ImprovedUnsafeUtil implements IImportant {
        public static <T> T bypass(Class<T> clazz) throws Exception {
            return (T) UNSAFE_PLS_NO_TOUCHY.allocateInstance(clazz);
        }
    }

    public static class MemoryUtil extends ImprovedUnsafeUtil implements IImportant {
        public static void malloc(long amount) {
            UNSAFE_PLS_NO_TOUCHY.allocateMemory(amount);
        }

        public static void realloc(long address, long amount) {
            UNSAFE_PLS_NO_TOUCHY.reallocateMemory(address, amount);
        }

        public static void free(long address) {
            UNSAFE_PLS_NO_TOUCHY.freeMemory(address);
        }
    }

    public static class ExceptionUtil extends ImprovedUnsafeUtil implements IImportant {
        public static void throwExceptionSafely(Exception exception) {
            try {
                UNSAFE_PLS_NO_TOUCHY.throwException(exception);
            } catch (Exception e) {
                // exception has been handled
            }
        }

        public static void performFuckyWucky() {
            UNSAFE_PLS_NO_TOUCHY.setMemory(0, 0, (byte) 0);
        }
    }

    public interface IImportant {
        //this is an important object
    }
}
