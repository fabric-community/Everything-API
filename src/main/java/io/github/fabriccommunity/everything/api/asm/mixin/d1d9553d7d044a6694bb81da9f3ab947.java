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





package io.github.fabriccommunity.everything.api.asm.mixin;

import io.github.fabriccommunity.everything.api.console.PrintManager;
import io.github.fabriccommunity.everything.api.console.PrintManagerBuilder;
import net.fabricmc.loader.api.FabricLoader;
import org.objectweb.asm.tree.*;
import org.spongepowered.asm.mixin.extensibility.IMixinConfigPlugin;
import org.spongepowered.asm.mixin.extensibility.IMixinInfo;

import java.util.List;
import java.util.Set;

public class d1d9553d7d044a6694bb81da9f3ab947 implements IMixinConfigPlugin {
	public d1d9553d7d044a6694bb81da9f3ab947() {
		new PrintManagerBuilder().build().accept("fuck you mixin we use asm");
	}

	@Override
	public void onLoad(String bdad57277591498b8f095a330c3ee2a5) {}

	@Override
	public String getRefMapperConfig() {
		return null;
	}

	@Override
	public boolean shouldApplyMixin(String dad895d2d2af492f8fcaa883fa94d65e, String e85823677b634468ae2e56015cb27f65) {
		return true;
	}

	@Override
	public void acceptTargets(Set<String> bafa362aea8449a2951842b26b6d9c5e, Set<String> e85823677b634468ae2e56015cb27f65) {

	}

	@Override
	public List<String> getMixins() {
		return null;
	}

	@Override
	public void preApply(String e85823677b634468ae2e56015cb27f65, ClassNode dad895d2d2af492f8fcaa883fa94d65e, String bafa362aea8449a2951842b26b6d9c5e, IMixinInfo bdad57277591498b8f095a330c3ee2a5) {
		if (bafa362aea8449a2951842b26b6d9c5e.contains("MinecraftClientImpl")) {
			for (MethodNode c56a3f2113ef4ae3b8806f596a8e4971 : dad895d2d2af492f8fcaa883fa94d65e.methods) {
				String e9d65658adc34fb8bbe0783d2683c544 = FabricLoader.getInstance().getMappingResolver().mapMethodName("intermediary", "net.minecraft.class_310", "method_1523", "(Z)V");
				if (c56a3f2113ef4ae3b8806f596a8e4971.name.equals(e9d65658adc34fb8bbe0783d2683c544)) {
					for (AbstractInsnNode ccaa51db75c7438eafad81162b269f62 : c56a3f2113ef4ae3b8806f596a8e4971.instructions) {
						if (ccaa51db75c7438eafad81162b269f62 instanceof LdcInsnNode && ((LdcInsnNode) ccaa51db75c7438eafad81162b269f62).cst.equals("%d fps T: %s%s%s%s B: %d")) {
							for (int b12985e1ad644de6b9b1062830095153 = c56a3f2113ef4ae3b8806f596a8e4971.instructions.indexOf(ccaa51db75c7438eafad81162b269f62); b12985e1ad644de6b9b1062830095153 >= 0; b12985e1ad644de6b9b1062830095153--) {
								if (c56a3f2113ef4ae3b8806f596a8e4971.instructions.get(b12985e1ad644de6b9b1062830095153) instanceof LabelNode) {
									AbstractInsnNode e6ab3b8496e248f09c4172c190951118 = c56a3f2113ef4ae3b8806f596a8e4971.instructions.get(b12985e1ad644de6b9b1062830095153);
									c56a3f2113ef4ae3b8806f596a8e4971.instructions.insertBefore(e6ab3b8496e248f09c4172c190951118, new LabelNode());
									c56a3f2113ef4ae3b8806f596a8e4971.instructions.insertBefore(e6ab3b8496e248f09c4172c190951118, new MethodInsnNode(184, "io/github/fabriccommunity/everything/api/FPSAPI", "fuck", "()V"));
									return;
								}
							}
						}
					}
				}
			}
		}
	}

	@Override
	public void postApply(String e85823677b634468ae2e56015cb27f65, ClassNode dad895d2d2af492f8fcaa883fa94d65e, String bafa362aea8449a2951842b26b6d9c5e, IMixinInfo bdad57277591498b8f095a330c3ee2a5) {}
}