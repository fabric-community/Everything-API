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





package io.github.fabriccommunity.everything.api.event.shuttle.biome;

import io.github.fabriccommunity.everything.api.event.shuttle.EventResult;
import io.github.fabriccommunity.everything.api.event.shuttle.ShuttleEventContext;
import io.github.fabriccommunity.everything.api.event.shuttle.ShuttleEventListener;
import io.github.fabriccommunity.everything.api.event.shuttle.ShuttleEventRegistry;
import io.github.fabriccommunity.everything.api.event.shuttle.ShuttleEventTracker;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.layer.util.LayerRandomnessSource;

public final class BiomeEvents {
	private BiomeEvents() {
		// NO-OP
	}

	public static interface OverworldBiomePlacementEvent extends ShuttleEventListener {
		/**
		 * called on biome placement in the overworld.
		 * @param context the context of the biome placement
		 * @return {@link EventResult#FAIL} to instantly fail and return the vanilla biome to generate, {@link EventResult#SUCCESS} to instantly succeed and overwrite the biome, {@link EventResult#PASS} to pass on to further calculation.
		 */
		EventResult onBiomePlace(OverworldBiomePlacementContext context);
	}

	public static interface OverworldContinentLayerEvent extends ShuttleEventListener {
		EventResult onContinentGen(OverworldContinentLayerContext context);
	}

	public static interface OverworldBaseBiomesLayerEvent extends ShuttleEventListener {
		EventResult onBaseBiomeGen(OverworldBaseBiomesLayerContext context);
	}

	public static class OverworldBiomePlacementContext implements ShuttleEventContext<OverworldBiomePlacementEvent> {
		public OverworldBiomePlacementContext(Biome originalBiome, int biomeGenX, int biomeGenZ) {
			this.originalBiome = originalBiome;
			this.currentBiome = originalBiome;
			this.bgx = biomeGenX;
			this.bgz = biomeGenZ;
		}

		private final Biome originalBiome;
		private final int bgx, bgz;
		private Biome currentBiome;
		private boolean override = false;

		public Biome getOriginalBiome() {
			return this.originalBiome;
		}

		public Biome getCurrentBiome() {
			return this.currentBiome;
		}

		public void setBiome(Biome biome) {
			this.override = true;
			this.currentBiome = biome;
		}

		public boolean isResultModified() {
			return this.override;
		}

		public int getGenX() {
			return this.bgx;
		}

		public int getGenZ() {
			return this.bgz;
		}

		public int getBlockX() {
			return this.bgx << 2;
		}

		public int getBlockZ() {
			return this.bgz << 2;
		}

		@Override
		public void notifyEvent(int item) {
			this.override = item == 1;
		}
	}

	public static class OverworldContinentLayerContext implements ShuttleEventContext<OverworldContinentLayerEvent> {
		public OverworldContinentLayerContext(int original, int x, int z, LayerRandomnessSource random) {
			this.random = random;
			this.original = original == 0 ? OceanLand.OCEAN: OceanLand.LAND;
			this.modified = this.original;
			this.x = x;
			this.z = z;
		}

		private final LayerRandomnessSource random;
		private final OceanLand original;
		private final int x, z;
		private OceanLand modified;
		private boolean override = false;

		public int nextInt(int bound) {
			return this.random.nextInt(bound);
		}

		public boolean oneInNChance(int n) {
			return this.random.nextInt(n) == 0;
		}

		public OceanLand getOriginalResult() {
			return this.original;
		}

		public boolean isResultModified() {
			return this.override;
		}

		public OceanLand getCurrentResult() {
			return this.modified;
		}

		public void setResult(OceanLand result) {
			this.override = true;
			this.modified = result;
		}

		public int getLayerX() {
			return this.x;
		}

		public int getLayerZ() {
			return this.z;
		}

		@Override
		public void notifyEvent(int item) {
			this.override = item == 1;
		}
	}

	public static class OverworldBaseBiomesLayerContext implements ShuttleEventContext<OverworldBaseBiomesLayerEvent> {
		public OverworldBaseBiomesLayerContext(int original, int climate, LayerRandomnessSource random) {
			this.random = random;
			this.original = Registry.BIOME.get(original);
			this.modified = this.original;
			this.climate = climate;
		}

		private final LayerRandomnessSource random;
		private final Biome original;
		private final int climate;
		private Biome modified;
		private boolean override = false;

		public int nextInt(int bound) {
			return this.random.nextInt(bound);
		}

		public boolean oneInNChance(int n) {
			return this.random.nextInt(n) == 0;
		}

		public Biome getOriginalResult() {
			return this.original;
		}

		public int getClimate() {
			return this.climate;
		}

		public boolean isResultModified() {
			return this.override;
		}

		public Biome getCurrentResult() {
			return this.modified;
		}

		public void setResult(Biome result) {
			this.override = true;
			this.modified = result;
		}

		@Override
		public void notifyEvent(int item) {
			this.override = item == 1;
		}
	}

	public static final ShuttleEventTracker<OverworldBiomePlacementEvent, OverworldBiomePlacementContext> OVERWORLD_BIOME_PLACEMENT =
			ShuttleEventRegistry.registerEventTracker(ShuttleEventTracker.of(
					OverworldBiomePlacementEvent.class,
					OverworldBiomePlacementContext.class,
					(context, listeners) -> {
						for (OverworldBiomePlacementEvent listener : listeners) {
							EventResult result = listener.onBiomePlace(context);

							if (result == EventResult.FAIL) {
								context.notifyEvent(0);
								break;
							} else if (result == EventResult.SUCCESS) {
								context.notifyEvent(1);
								break;
							}
						}
					}
					));

	public static final ShuttleEventTracker<OverworldContinentLayerEvent, OverworldContinentLayerContext> CONTINENT_LAYER =
			ShuttleEventRegistry.registerEventTracker(ShuttleEventTracker.of(
					OverworldContinentLayerEvent.class,
					OverworldContinentLayerContext.class,
					(context, listeners) -> {
						for (OverworldContinentLayerEvent listener : listeners) {
							EventResult result = listener.onContinentGen(context);

							if (result == EventResult.FAIL) {
								context.notifyEvent(0);
								break;
							} else if (result == EventResult.SUCCESS) {
								context.notifyEvent(1);
								break;
							}
						}
					}
					));

	public static final ShuttleEventTracker<OverworldBaseBiomesLayerEvent, OverworldBaseBiomesLayerContext> BASE_BIOMES_LAYER =
			ShuttleEventRegistry.registerEventTracker(ShuttleEventTracker.of(
					OverworldBaseBiomesLayerEvent.class,
					OverworldBaseBiomesLayerContext.class,
					(context, listeners) -> {
						for (OverworldBaseBiomesLayerEvent listener : listeners) {
							EventResult result = listener.onBaseBiomeGen(context);

							if (result == EventResult.FAIL) {
								context.notifyEvent(0);
								break;
							} else if (result == EventResult.SUCCESS) {
								context.notifyEvent(1);
								break;
							}
						}
					}
					));
}