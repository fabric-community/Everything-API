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

package io.github.fabriccommunity.everything.api.exception;

import java.util.Arrays;
import java.util.Random;

public class FuckException extends RuntimeException {
		public FuckException() {
			System.out.println(" +\"\"\"\"\"+ ");
        System.out.println("[| o o |]");
        System.out.println(" |  ^  | ");
        System.out.println(" | '-' | ");
        System.out.println(" +-----+ ");
			System.out.println("and then he turned into an NPE, funniest shit i've ever seen - fran");
			super(Arrays.asList("Fuck", "FUCK", "FuCk", "FUUUUCK!", "FUCK!!!", "FUCKKKKKKKKK!!!").get(new Random().nextInt(5)));
		}
}
