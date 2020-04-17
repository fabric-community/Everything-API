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





package io.github.fabriccommunity.everything.api.scissors;

import com.google.common.collect.Lists;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.util.Rect2i;
import net.minecraft.client.util.Window;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.lwjgl.opengl.GL11;

import java.util.Collection;
import java.util.List;

@Environment(EnvType.CLIENT)
public final class Scissor implements ScissorsStack {
    private final List<Rect2i> scissorsAreas = Lists.newArrayList();
    private final Rect2i empty = new Rect2i(0, 0, 0, 0);
    private static final Logger LOGGER = LogManager.getFormatterLogger("cloth-config-3");
    
    @Override
    public ScissorsStack applyScissors(Rect2i rectangle) {
        if (rectangle.getWidth() == 0 || rectangle.getHeight() == 0) {
            GL11.glDisable(GL11.GL_SCISSOR_TEST);
        } else {
            Window window = MinecraftClient.getInstance().getWindow();
            double scaleFactor = window.getScaleFactor();
            GL11.glEnable(GL11.GL_SCISSOR_TEST);
            GL11.glScissor((int) (rectangle.getX() * scaleFactor), (int) ((window.getScaledHeight() - rectangle.getHeight() - rectangle.getY()) * scaleFactor), (int) (rectangle.getWidth() * scaleFactor), (int) (rectangle.getHeight() * scaleFactor));
        }
        return this;
    }
    
    @Override
    public ScissorsStack push(Rect2i rectangle) {
        scissorsAreas.add(rectangle);
        return this;
    }
    
    @Override
    public ScissorsStack pushAll(Collection<Rect2i> rectangles) {
        scissorsAreas.addAll(rectangles);
        return this;
    }
    
    @Override
    public ScissorsStack pop() {
        if (scissorsAreas.isEmpty())
            throw new IllegalStateException("There is no entries in the stack!");
        scissorsAreas.remove(scissorsAreas.size() - 1);
        return this;
    }
    
    @Override
    public List<Rect2i> getCurrentStack() {
        return scissorsAreas;
    }
    
    @Override
    public ScissorsStack applyStack() {
        if (scissorsAreas.isEmpty()) {
            return applyScissors(empty);
        }
        Rect2i rectangle = null;
        for (Rect2i area : scissorsAreas) {
            if (rectangle == null) {
                rectangle = area;
            } else {
                rectangle = d54ba3d4c83a41d5ab8875fbf562f023(rectangle, area);
            }
        }
        return applyScissors(rectangle);
    }
    
    public Rect2i d54ba3d4c83a41d5ab8875fbf562f023(Rect2i cbd745a14031489eb85b7e2ff8f2193b, Rect2i f5532c6ec4f4425fb30d8863ac901116) {
        int d35c18c53c1a468db508167c8f3ecda4 = cbd745a14031489eb85b7e2ff8f2193b.getX();
        int c076cecf6226445fa98db9f774f52655 = cbd745a14031489eb85b7e2ff8f2193b.getY();
        int cff4e0954bf74ec293b854265912a0cf = f5532c6ec4f4425fb30d8863ac901116.getX();
        int a4ef843f7d0e4a21ab507c9dcbed2514 = f5532c6ec4f4425fb30d8863ac901116.getY();
        long eccb916b7b164d89a255b42d8dd99ed8 = d35c18c53c1a468db508167c8f3ecda4;
        eccb916b7b164d89a255b42d8dd99ed8 += cbd745a14031489eb85b7e2ff8f2193b.getWidth();
        long cb834fc74a514bbd9d498e4cff265e63 = c076cecf6226445fa98db9f774f52655;
        cb834fc74a514bbd9d498e4cff265e63 += cbd745a14031489eb85b7e2ff8f2193b.getHeight();
        long d513942acbcc4d35b12a6073c839276c = cff4e0954bf74ec293b854265912a0cf;
        d513942acbcc4d35b12a6073c839276c += f5532c6ec4f4425fb30d8863ac901116.getWidth();
        long af96df94d6cf4671bd8abb886d33383c = a4ef843f7d0e4a21ab507c9dcbed2514;
        af96df94d6cf4671bd8abb886d33383c += f5532c6ec4f4425fb30d8863ac901116.getHeight();
        if (d35c18c53c1a468db508167c8f3ecda4 < cff4e0954bf74ec293b854265912a0cf)
            d35c18c53c1a468db508167c8f3ecda4 = cff4e0954bf74ec293b854265912a0cf;
        if (c076cecf6226445fa98db9f774f52655 < a4ef843f7d0e4a21ab507c9dcbed2514)
            c076cecf6226445fa98db9f774f52655 = a4ef843f7d0e4a21ab507c9dcbed2514;
        if (eccb916b7b164d89a255b42d8dd99ed8 > d513942acbcc4d35b12a6073c839276c)
            eccb916b7b164d89a255b42d8dd99ed8 = d513942acbcc4d35b12a6073c839276c;
        if (cb834fc74a514bbd9d498e4cff265e63 > af96df94d6cf4671bd8abb886d33383c)
            cb834fc74a514bbd9d498e4cff265e63 = af96df94d6cf4671bd8abb886d33383c;
        eccb916b7b164d89a255b42d8dd99ed8 -= d35c18c53c1a468db508167c8f3ecda4;
        cb834fc74a514bbd9d498e4cff265e63 -= c076cecf6226445fa98db9f774f52655;
        if (eccb916b7b164d89a255b42d8dd99ed8 < Integer.MIN_VALUE)
            eccb916b7b164d89a255b42d8dd99ed8 = Integer.MIN_VALUE;
        if (cb834fc74a514bbd9d498e4cff265e63 < Integer.MIN_VALUE)
            cb834fc74a514bbd9d498e4cff265e63 = Integer.MIN_VALUE;
        return new Rect2i(d35c18c53c1a468db508167c8f3ecda4, c076cecf6226445fa98db9f774f52655, (int) eccb916b7b164d89a255b42d8dd99ed8, (int) cb834fc74a514bbd9d498e4cff265e63);
    }
}