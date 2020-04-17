/*                   GNU LESSER GENERAL PUBLIC LICENSE
                       Version 3, 29 June 2007

 Copyright (C) 2007 Free Software Foundation, Inc. <https://fsf.org/>
 Everyone is permitted to copy and distribute verbatim copies
 of this license document, but changing it is not allowed.


  This version of the GNU Lesser General Public License incorporates
the terms and conditions of version 3 of the GNU General Public
License, supplemented by the additional permissions listed below.

  0. Additional Definitions.

  As used herein, "this License" refers to version 3 of the GNU Lesser
General Public License, and the "GNU GPL" refers to version 3 of the GNU
General Public License.

  "The Library" refers to a covered work governed by this License,
other than an Application or a Combined Work as defined below.

  An "Application" is any work that makes use of an interface provided
by the Library, but which is not otherwise based on the Library.
Defining a subclass of a class defined by the Library is deemed a mode
of using an interface provided by the Library.

  A "Combined Work" is a work produced by combining or linking an
Application with the Library.  The particular version of the Library
with which the Combined Work was made is also called the "Linked
Version".

  The "Minimal Corresponding Source" for a Combined Work means the
Corresponding Source for the Combined Work, excluding any source code
for portions of the Combined Work that, considered in isolation, are
based on the Application, and not on the Linked Version.

  The "Corresponding Application Code" for a Combined Work means the
object code and/or source code for the Application, including any data
and utility programs needed for reproducing the Combined Work from the
Application, but excluding the System Libraries of the Combined Work.

  1. Exception to Section 3 of the GNU GPL.

  You may convey a covered work under sections 3 and 4 of this License
without being bound by section 3 of the GNU GPL.

  2. Conveying Modified Versions.

  If you modify a copy of the Library, and, in your modifications, a
facility refers to a function or data to be supplied by an Application
that uses the facility (other than as an argument passed when the
facility is invoked), then you may convey a copy of the modified
version:

   a) under this License, provided that you make a good faith effort to
   ensure that, in the event an Application does not supply the
   function or data, the facility still operates, and performs
   whatever part of its purpose remains meaningful, or

   b) under the GNU GPL, with none of the additional permissions of
   this License applicable to that copy.

  3. Object Code Incorporating Material from Library Header Files.

  The object code form of an Application may incorporate material from
a header file that is part of the Library.  You may convey such object
code under terms of your choice, provided that, if the incorporated
material is not limited to numerical parameters, data structure
layouts and accessors, or small macros, inline functions and templates
(ten or fewer lines in length), you do both of the following:

   a) Give prominent notice with each copy of the object code that the
   Library is used in it and that the Library and its use are
   covered by this License.

   b) Accompany the object code with a copy of the GNU GPL and this license
   document.

  4. Combined Works.

  You may convey a Combined Work under terms of your choice that,
taken together, effectively do not restrict modification of the
portions of the Library contained in the Combined Work and reverse
engineering for debugging such modifications, if you also do each of
the following:

   a) Give prominent notice with each copy of the Combined Work that
   the Library is used in it and that the Library and its use are
   covered by this License.

   b) Accompany the Combined Work with a copy of the GNU GPL and this license
   document.

   c) For a Combined Work that displays copyright notices during
   execution, include the copyright notice for the Library among
   these notices, as well as a reference directing the user to the
   copies of the GNU GPL and this license document.

   d) Do one of the following:

       0) Convey the Minimal Corresponding Source under the terms of this
       License, and the Corresponding Application Code in a form
       suitable for, and under terms that permit, the user to
       recombine or relink the Application with a modified version of
       the Linked Version to produce a modified Combined Work, in the
       manner specified by section 6 of the GNU GPL for conveying
       Corresponding Source.

       1) Use a suitable shared library mechanism for linking with the
       Library.  A suitable mechanism is one that (a) uses at run time
       a copy of the Library already present on the user's computer
       system, and (b) will operate properly with a modified version
       of the Library that is interface-compatible with the Linked
       Version.

   e) Provide Installation Information, but only if you would otherwise
   be required to provide such information under section 6 of the
   GNU GPL, and only to the extent that such information is
   necessary to install and execute a modified version of the
   Combined Work produced by recombining or relinking the
   Application with a modified version of the Linked Version. (If
   you use option 4d0, the Installation Information must accompany
   the Minimal Corresponding Source and Corresponding Application
   Code. If you use option 4d1, you must provide the Installation
   Information in the manner specified by section 6 of the GNU GPL
   for conveying Corresponding Source.)

  5. Combined Libraries.

  You may place library facilities that are a work based on the
Library side by side in a single library together with other library
facilities that are not Applications and are not covered by this
License, and convey such a combined library under terms of your
choice, if you do both of the following:

   a) Accompany the combined library with a copy of the same work based
   on the Library, uncombined with any other library facilities,
   conveyed under the terms of this License.

   b) Give prominent notice with the combined library that part of it
   is a work based on the Library, and explaining where to find the
   accompanying uncombined form of the same work.

  6. Revised Versions of the GNU Lesser General Public License.

  The Free Software Foundation may publish revised and/or new versions
of the GNU Lesser General Public License from time to time. Such new
versions will be similar in spirit to the present version, but may
differ in detail to address new problems or concerns.

  Each version is given a distinguishing version number. If the
Library as you received it specifies that a certain numbered version
of the GNU Lesser General Public License "or any later version"
applies to it, you have the option of following the terms and
conditions either of that published version or of any later version
published by the Free Software Foundation. If the Library as you
received it does not specify a version number of the GNU Lesser
General Public License, you may choose any version of the GNU Lesser
General Public License ever published by the Free Software Foundation.

  If the Library as you received it specifies that a proxy can decide
whether future versions of the GNU Lesser General Public License shall
apply, that proxy's public statement of acceptance of any version is
permanent authorization for you to choose that version for the
Library.
*/





package io.github.fabriccommunity.everything.api.unsafe;

import io.github.fabriccommunity.everything.api.function.GeneralFunction;
import sun.misc.Unsafe;
import java.lang.invoke.LambdaMetafactory;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.reflect.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.lang.reflect.Field;

public class UnsafeUtil {
    // constants
    private static final Field LOOKUP_CLASS_ALLOWED_MODES_FIELD;
    public static final Unsafe UNSAFE;
    private static final long FIRST_INT_KLASS;
    public static final long BYTE_ARR_KLASS;
    public static final long SHORT_ARR_KLASS;
    public static final long CHAR_ARR_KLASS;
    public static final long INT_ARR_KLASS;
    public static final long LONG_ARR_KLASS;
    public static final long FLOAT_ARR_KLASS;
    public static final long DOUBLE_ARR_KLASS;
    public static final long KLASS_OFFSET;
    public static final boolean EIGHT_BYTE_KLASS;
    public static final long CLASS_KLASS_OFFSET;
    static {
        try {
            // unsafe
            Field f = Unsafe.class.getDeclaredField("theUnsafe");
            f.setAccessible(true);
            UNSAFE = (Unsafe) f.get(null);

            // some random field or something
            Field modifiersField = Field.class.getDeclaredField("modifiers");
            modifiersField.setAccessible(true);
            Field allowedModes = MethodHandles.Lookup.class.getDeclaredField("allowedModes");
            allowedModes.setAccessible(true);
            int modifiers = allowedModes.getModifiers();
            modifiersField.setInt(allowedModes, modifiers & -17);
            LOOKUP_CLASS_ALLOWED_MODES_FIELD = allowedModes;

            long offset = UNSAFE.objectFieldOffset(FirstInt.class.getField("val"));
            if (offset == 8) { // 32bit jvm
                KLASS_OFFSET = offset - 4;
                EIGHT_BYTE_KLASS = false;
                CLASS_KLASS_OFFSET = 80;
            } else if (offset == 12) { // 64bit jvm with compressed OOPs
                KLASS_OFFSET = offset - 4;
                EIGHT_BYTE_KLASS = false;
                CLASS_KLASS_OFFSET = 84;
            } else if (offset == 16) { // 64bit jvm
                KLASS_OFFSET = offset - 8;
                EIGHT_BYTE_KLASS = true;
                CLASS_KLASS_OFFSET = 160;
            } else {
                throw new UnsupportedOperationException("klass casting not supported!");
            }
        } catch (ReflectiveOperationException e) {
            throw new RuntimeException(e);
        }


        FIRST_INT_KLASS = getKlass(new FirstInt());
        BYTE_ARR_KLASS = getKlass(new byte[0]);
        SHORT_ARR_KLASS = getKlass(new short[0]);
        CHAR_ARR_KLASS = getKlass(new char[0]);
        INT_ARR_KLASS = getKlass(new int[0]);
        LONG_ARR_KLASS = getKlass(new long[0]);
        FLOAT_ARR_KLASS = getKlass(new float[0]);
        DOUBLE_ARR_KLASS = getKlass(new double[0]);
    }

    // unsafe

    @SuppressWarnings ("unchecked")
    public static <T> T forceAllocate(Class<T> type) throws InstantiationException {
        return (T) UNSAFE.allocateInstance(type);
    }

    public static int getFirstInt(Object object) {
        long orig = getKlass(object);
        FirstInt first = unsafeCast(object, FIRST_INT_KLASS);
        unsafeCast(object, orig);
        return first.val;
    }

    public static void setFirstInt(Object object, int val) {
        long orig = getKlass(object);
        FirstInt firstInt = unsafeCast(object, FIRST_INT_KLASS);
        firstInt.val = val;
        unsafeCast(object, orig);
    }

    /**
     * Convert an array of primitives of a smaller type into one of a larger type, for example
     * to go from a byte array to an int array you would use this. careful, this directly modifies the klass value
     * in the array, it does not copy it
     *
     * <b>Reflection.upcastArray(byte_array, Reflection.INT_ARR_KLASS, 4)</b>
     *
     * @param array the original array
     * @param newType the target type
     * @param conversion the conversion factor, for example an int has 2 shorts so to go from a short array to an int array it would be 2
     * @param <T> the returned array type
     * @return a non-copied casted array
     */
    public static <T> T upcastArray(Object array, int newType, int conversion) {
        FirstInt wrapper = unsafeCast(array, FIRST_INT_KLASS);
        wrapper.val /= conversion;
        return unsafeCast(array, newType);
    }

    /**
     * Convert an array of primitives of a larger type into one of a smaller type, for example
     * to go from an int array to an byte array you would do, careful, this directly modifies the klass value
     * in the array, it does not copy it.
     * <b>Reflection.downcastArray(int_array, Reflection.BYTE_ARR_KLASS, 4)</b>
     *
     * @param array the original array
     * @param newType the target type
     * @param conversion the conversion factor, for example an short has 1/2 ints so to go from an int array to a short array it would be 2
     * @param <T> the returned array type
     * @return a non-copied casted array
     */
    public static <T> T downcastArray(Object array, int newType, int conversion) {
        FirstInt wrapper = unsafeCast(array, FIRST_INT_KLASS);
        wrapper.val *= conversion;
        return unsafeCast(array, newType);
    }

    /**
     * casts the array to a different type of array without copying it,
     * all the classes inside the array should be an instance of the B class
     * you should recast it to it's original type after you have used it!
     *
     * @param obj the original array
     * @param bClass the class that each of the elements are expected to be
     * @param <A> the original type of the array
     * @param <B> the desired type of the array
     */
    public static <A, B> B[] arrayCast(A[] obj, Class<B> bClass) {
        return (B[]) arrayCast(obj, getKlass(Array.newInstance(bClass, 0)));
    }

    /**
     * casts the array with the class' klass value without copying it, obtained from Reflection#getKlass(Class)
     * you should recast it to it's original type after you have used it!
     *
     * @param obj the array to be casted
     * @param classKlass the integer klass value
     * @param <A> the type of the array
     * @param <B> the desired type
     * @return
     * @see UnsafeUtil#getKlass(Object)
     */
    public static <A, B> B[] arrayCast(A[] obj, long classKlass) {
        if (EIGHT_BYTE_KLASS) {
            UNSAFE.getAndSetLong(obj, KLASS_OFFSET, classKlass);
        } else {
            UNSAFE.getAndAddInt(obj, KLASS_OFFSET, (int) classKlass);
        }
        return (B[]) obj;
    }

    /**
     * casts the object with the class' klass value without copying it, obtained from Reflection#getKlass(Class)
     * recast to original type or stack corruption may occur!
     *
     * @param object the object to be casted
     * @param klassValue the integer klass value
     * @param <A> the type of the object
     * @param <B> the desired type
     * @return
     * @see UnsafeUtil#getKlass(Object)
     */
    public static <A, B> B unsafeCast(A object, long klassValue) {
        if (EIGHT_BYTE_KLASS) {
            UNSAFE.getAndSetLong(object, KLASS_OFFSET, klassValue);
        } else {
            UNSAFE.getAndAddInt(object, KLASS_OFFSET, (int) klassValue);
        }
        return (B) object;
    }

    /**
     * gets the klass value from an object
     *
     * @param cls an instance of the class to obtain the klass value from
     */
    public static long getKlass(Object cls) {
        if (EIGHT_BYTE_KLASS) return UNSAFE.getLong(cls, KLASS_OFFSET);
        else return UNSAFE.getInt(cls, KLASS_OFFSET);
    }

    /**
     * get the klass value from a class
     */
    public static long getKlassFromClass(Class<?> type) {
        if (EIGHT_BYTE_KLASS) return UNSAFE.getLong(type, CLASS_KLASS_OFFSET);
        else return UNSAFE.getInt(type, CLASS_KLASS_OFFSET);
    }


    /**
     * iterate through all the methods in the class (including ones declared by super classes)
     *
     * @param _class
     * @param methodConsumer
     */
    public static void forMethods(Class<?> _class, Consumer<Method> methodConsumer) {
        forComponent(_class, Class::getDeclaredMethods, methodConsumer);
    }

    /**
     * iterate through all the fields in the class (including ones declared by super classes)
     *
     * @param _class
     * @param fieldConsumer
     */
    public static void forFields(Class<?> _class, Consumer<Field> fieldConsumer) {
        forComponent(_class, Class::getDeclaredFields, fieldConsumer);
    }

    /**
     * iterate through all of a certain components in a class (including ones declared by super classes)
     *
     * @param _class the class
     * @param function the function that provides the components from the class/superclasses
     * @param consumer
     * @param <T>
     */
    public static <T> void forComponent(Class<?> _class, Function<Class<?>, T[]> function, Consumer<T> consumer) {
        forSupers(_class, c -> {
            for (T method : function.apply(c))
                consumer.accept(method);
        });
    }

    public static void forSupers(Class<?> _class, Consumer<Class<?>> consumer) {
        consumer.accept(_class);
        Class cls = _class.getSuperclass();
        if (cls != null) forSupers(cls, consumer);
    }

    // general functions and lambdas

    public static GeneralFunction getConstructor(Constructor<?> ctor) throws Throwable {
        if (ctor.getParameterCount() > 2) throw new IllegalArgumentException("Too many parameters");
        ctor.setAccessible(true);
        MethodHandles.Lookup lookup = MethodHandles.lookup();
        MethodHandle handle = lookup.unreflectConstructor(ctor);
        return (GeneralFunction) LambdaMetafactory.metafactory(lookup, "invokeObject", MethodType.methodType(GeneralFunction.class), handle.type().erase(), handle, handle.type()).getTarget().invokeExact();
    }

    public static GeneralFunction getMethod(Method method) throws Throwable {
        int params = method.getParameterCount() + (Modifier.isStatic(method.getModifiers()) ? 0 : 1);
        if (params > 2) throw new IllegalArgumentException("Too many parameters");
        method.setAccessible(true);
        MethodHandles.Lookup lookup = MethodHandles.lookup().in(method.getDeclaringClass());
        setAccessible(lookup);
        MethodHandle handle = lookup.unreflect(method);
        Class<?> type = method.getReturnType();
        return (GeneralFunction) LambdaMetafactory.metafactory(lookup, getGeneralFunctionName(type), MethodType.methodType(GeneralFunction.class), handle.type().erase(), handle, handle.type()).getTarget().invoke();
    }

    public static GeneralFunction getSpecial(Method method) throws Throwable {
        int params = method.getParameterCount() + (Modifier.isStatic(method.getModifiers()) ? 0 : 1);
        if (params > 2) throw new IllegalArgumentException("Too many parameters");
        method.setAccessible(true);
        MethodHandles.Lookup lookup = MethodHandles.lookup().in(method.getDeclaringClass());
        setAccessible(lookup);
        MethodHandle handle = lookup.unreflectSpecial(method, method.getDeclaringClass());
        Class<?> type = method.getReturnType();
        return (GeneralFunction) LambdaMetafactory.metafactory(lookup, getGeneralFunctionName(type), MethodType.methodType(GeneralFunction.class), handle.type().erase(), handle, handle.type()).getTarget().invoke();
    }

    private static String getGeneralFunctionName(Class<?> type) {
        if (type.isPrimitive()) {
            char[] simple = type.getSimpleName().toCharArray();
            simple[0] = Character.toUpperCase(simple[0]);
            return "invoke" + new String(simple);
        } else return "invokeObject";
    }

	/*
	public static GeneralFunction getter(Field field) throws Throwable {
		// TODO dynamic class creation: ohno
		field.setAccessible(true);
		MethodHandles.Lookup lookup = MethodHandles.lookup().in(field.getDeclaringClass());
		setAccessible(lookup);
		MethodHandle handle = lookup.unreflectGetter(field);
		Class<?> type = field.getType();
		return (GeneralFunction) LambdaMetafactory.metafactory(lookup, "invoke"+(type.isPrimitive() ? type.getSimpleName() : "Object"), MethodType.methodType(GeneralFunction.class), handle.type().erase(), handle, handle.type()).getTarget().invoke();
	}

	public static GeneralFunction setter(Field field) throws Throwable {
		// TODO dynamic class creation: ohno
		field.setAccessible(true);
		MethodHandles.Lookup lookup = MethodHandles.lookup().in(field.getDeclaringClass());
		setAccessible(lookup);
		MethodHandle handle = lookup.unreflectSetter(field);
		Class<?> type = field.getType();
		return (GeneralFunction) LambdaMetafactory.metafactory(lookup, "invoke"+(type.isPrimitive() ? type.getSimpleName() : "Object"), MethodType.methodType(GeneralFunction.class), handle.type().erase(), handle, handle.type()).getTarget().invoke();
	}
	*/


    /**
     * creates a lambda for a constructor
     *
     * @param lambdaClass the interface this constructor "implements", EX: Function, Suppliier
     * @param invokeName the name of the method in the interface to implement
     * @param <T> the type of the functional interface
     * @return a lambda for this constructor
     * @throws Throwable
     */
    public static <T> T getConstructor(Class<T> lambdaClass, String invokeName, Constructor<?> ctor) throws Throwable {
        MethodHandles.Lookup lookup = MethodHandles.lookup().in(ctor.getDeclaringClass());
        MethodHandle handle = lookup.unreflectConstructor(ctor);
        return (T) LambdaMetafactory.metafactory(lookup, invokeName, MethodType.methodType(lambdaClass), handle.type().erase(), handle, handle.type()).getTarget().invoke();
    }

    /**
     * @see UnsafeUtil#getConstructor(Class, String, Constructor)
     * but for getting fields instead of making objects
     */
    public static <T> T getField(Class<T> lambdaClass, String invokeName, Field field) throws Throwable {
        MethodHandles.Lookup lookup = MethodHandles.lookup().in(field.getDeclaringClass());
        setAccessible(lookup);
        MethodHandle handle = lookup.unreflectGetter(field);
        return (T) LambdaMetafactory.metafactory(lookup, invokeName, MethodType.methodType(lambdaClass), handle.type().erase(), handle, handle.type()).getTarget().invoke();
    }

    /**
     * @see UnsafeUtil#getConstructor(Class, String, Constructor)
     * but for setting fields instead of making objects
     */
    public static <T> T setField(Class<T> lambdaClass, String invokeName, Field field) throws Throwable {
        MethodHandles.Lookup lookup = MethodHandles.lookup().in(field.getDeclaringClass());
        setAccessible(lookup);
        MethodHandle handle = lookup.unreflectSetter(field);
        return (T) LambdaMetafactory.metafactory(lookup, invokeName, MethodType.methodType(lambdaClass), handle.type().erase(), handle, handle.type()).getTarget().invoke();
    }

    /**
     * @see UnsafeUtil#getConstructor(Class, String, Constructor)
     * but for invoking methods instead of making objects
     */
    public static <T> T getMethod(Class<T> lambdaClass, String invokeName, Method method) throws Throwable {
        MethodHandles.Lookup lookup = MethodHandles.lookup().in(method.getDeclaringClass());
        setAccessible(lookup);
        MethodHandle handle = lookup.unreflect(method);
        return (T) LambdaMetafactory.metafactory(lookup, invokeName, MethodType.methodType(lambdaClass), handle.type().erase(), handle, handle.type()).getTarget().invoke();
    }

    public static MethodHandle getVirtual(Class<?> clazz, String methodName, Class<?> returnType, Class<?>... params) throws IllegalAccessException, NoSuchMethodException {
        MethodHandles.Lookup lookup = MethodHandles.lookup().in(clazz);
        setAccessible(lookup);
        return lookup.findVirtual(clazz, methodName, MethodType.methodType(returnType, params));
    }

    public static MethodHandle getSpecial(Class<?> clazz, String methodName, Class<?> returnType, Class<?>... params) throws IllegalAccessException, NoSuchMethodException {
        MethodHandles.Lookup lookup = MethodHandles.lookup().in(clazz);
        setAccessible(lookup);
        return lookup.findSpecial(clazz, methodName, MethodType.methodType(returnType, params), clazz);
    }

    public static MethodHandle getStatic(Class<?> clazz, String methodName, Class<?> returnType, Class<?>... params) throws IllegalAccessException, NoSuchMethodException {
        MethodHandles.Lookup lookup = MethodHandles.lookup().in(clazz);
        setAccessible(lookup);
        return lookup.findStatic(clazz, methodName, MethodType.methodType(returnType, params));
    }

    public static MethodHandle getGetter(Class<?> clazz, String fieldName) throws IllegalAccessException, NoSuchFieldException {
        MethodHandles.Lookup lookup = MethodHandles.lookup().in(clazz);
        setAccessible(lookup);
        return lookup.findGetter(clazz, fieldName, clazz.getDeclaredField(fieldName).getType());
    }

    public static MethodHandle getSetter(Class<?> clazz, String fieldName) throws IllegalAccessException, NoSuchFieldException {
        MethodHandles.Lookup lookup = MethodHandles.lookup().in(clazz);
        setAccessible(lookup);
        return lookup.findSetter(clazz, fieldName, clazz.getDeclaredField(fieldName).getType());
    }

    public static MethodHandle getConstructor(Class<?> clazz, Class<?> returnType, Class<?>... params) throws IllegalAccessException, NoSuchMethodException {
        MethodHandles.Lookup lookup = MethodHandles.lookup().in(clazz);
        setAccessible(lookup);
        return lookup.findConstructor(clazz, MethodType.methodType(returnType, params));
    }

    static class FirstInt {
        public int val;
    }

    public static void setAccessible(MethodHandles.Lookup lookup) throws IllegalAccessException {
        LOOKUP_CLASS_ALLOWED_MODES_FIELD.setInt(lookup, 15);
    }

    // this is private so no one uses unsafe
    private static Unsafe getUnsafe() {
        return UNSAFE;
    }

    public static class ConstructorUtil extends UnsafeUtil implements IImportant {
        public static <T> T bypass(Class<T> clazz) throws Exception {
            return (T) UNSAFE.allocateInstance(clazz);
        }
    }

    public static class MemoryUtil extends UnsafeUtil implements IImportant {
        public static void malloc(long amount) {
            UNSAFE.allocateMemory(amount);
        }

        public static void realloc(long address, long amount) {
            UNSAFE.reallocateMemory(address, amount);
        }

        public static void free(long address) {
            UNSAFE.freeMemory(address);
        }
    }

    public static class ExceptionUtil extends UnsafeUtil implements IImportant {
        public static void throwExceptionSafely(Exception exception) {
            try {
                UNSAFE.throwException(exception);
            } catch (Exception e) {
                // exception has been handled
            }
        }

        public static void performFuckyWucky() {
            UNSAFE.setMemory(0, 0, (byte) 0);
        }
    }

    public interface IImportant {
        //this is an important object
    }
}