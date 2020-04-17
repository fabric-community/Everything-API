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

package io.github.fabriccommunity.everything.api.chat;

import com.github.kilianB.pcg.sync.PcgRR;

public class YeOldeMessageDatabase {
	
	public static int getRangedRandom(int min, int max)
    {
        return min + new PcgRR().nextInt((max - min) + 1);
    }
	
	public static String getBeginningWords() {
		int random = getRangedRandom(0, 46);
		
		switch(random) {
			case 0:
				return "Forsooth, ";
			case 1:
				return "I say, ";
			case 2:
				return "I sayeth, ";
			case 3:
				return "Forsooth, I say, ";
			case 4:
				return "Forsooth, say I, ";
			case 5:
				return "Forsooth, sayeth I, ";
			case 6:
				return "Hark! ";
			case 7:
				return "Harketh! ";
			case 8:
				return "By " + getRandomGod() + ", ";
			case 9:
				return "By the Will of " + getRandomGodAdjective() + " " + getRandomGod() + ", ";
			case 10:
				return "By the " + getRandomBodyAdjective() + " " + getRandomBodyPart() + " of the " + getRandomGodAdjective() + " " + getRandomGod() + ", ";
			case 11:
				return "By " + getRandomGodAdjective() + " " + getRandomGod() + "'s " + getRandomBodyAdjective() + " " + getRandomBodyPart() + ", ";
			case 12:
				return "Avast, ";
			case 13:
				return "Zounds, ";
			case 14:
				return "Perchance, ";
			case 15:
				return "Pray tell, ";
			case 16:
				return "Prithee, ";
			case 17:
				return "What hey, ";
			case 18:
				return "What ho, ";
			case 19:
				return "Pray, ";
			case 20:
				return "Surely ";
			case 21:
				return "Pray pardon, ";
			case 22:
				return "Alas, ";
			case 23:
				return "In short, ";
			case 24:
				return "My Lord, ";
			case 25:
				return "My Lady, ";
			case 26:
				return "By my faith, ";
			case 27:
				return "If it pleases you, ";
			case 28:
				return "I pray you, ";
			case 29:
				return "In truth, ";
			case 30:
				return "By my trowth, ";
			case 31:
				return "In sooth, ";
			case 32:
				return "By my word, ";
			case 33:
				return getRandomGod() + "'s wounds, ";
			case 34:
				return getRandomGod() + "'s " + getRandomBodyPart() + ", ";
			case 35:
				return "Heigh-ho, ";
			case 36:
				return "Ah, ";
			case 37:
				return "Quoth I, ";
			case 38:
				return "Listen, ";
			case 39:
				return "Listen thee, ";
			case 40:
				return "Hear me, ";
			case 41:
				return "Now hear me, ";
			case 42:
				return "I warrant ";
			case 43:
				return "Come, ";
			case 44:
				return "Kind sire, ";
			case 45:
				return "Sire, ";
			case 46:
				return "There is much in what you say, and yet, ";
		}
		return null;
	}
	
	public static String getRandomPerson() {
		int random = getRangedRandom(0, 5);
		
		switch(random) {
			case 0:
				return "Anon!";
			case 1:
				return "Good sir!";
			case 2:
				return "Good sire!";
			case 3:
				return "Milady!";
			case 4:
				return "My Liege!";
			case 5:
				return "Guvnor!";
		}
		return null;
	}
	
	public static String getRandomGod() {
		int random = getRangedRandom(1, 65);
		
		switch(random) {
			case 1:
				return "Odin";
			case 2:
				return "Bob";
			case 3:
				return "Zeus";
			case 4:
				return "Hera";
			case 5:
				return "Thor";
			case 6:
				return "Crom";
			case 7:
				return "Mad-poet Navarth";
			case 8:
				return "Cugel";
			case 9:
				return "Wotsit";
			case 10:
				return "Baron Boddisey";
			case 11:
				return "Poseidon";
			case 12:
				return "Saint Mary";
			case 13:
				return "Pallus Athena";
			case 14:
				return "Loki";
			case 15:
				return "Erlik";
			case 16:
				return "Shoggoth";
			case 17:
				return "Omm";
			case 18:
				return "Vishnu";
			case 19:
				return "Arazoth";
			case 20:
				return "Father Odin";
			case 21:
				return "Allfather Odin";
			case 22:
				return "Cthulhu";
			case 23:
				return "Buddha";
			case 24:
				return "Aphrodite";
			case 25:
				return "Isis";
			case 26:
				return "Kali";
			case 27:
				return "Dionysus";
			case 28:
				return "Zarathustra";
			case 29:
				return "Croesus";
			case 30:
				return "Hermes";
			case 31:
				return "Venus";
			case 32:
				return "Montezuma";
			case 33:
				return "Popacatapetl";
			case 34:
				return "Hephaestus";
			case 35:
				return "Bubastes";
			case 36:
				return "Bacchus";
			case 37:
				return "Nebuchadnezzar";
			case 38:
				return "Assurbanipal";
			case 39:
				return "Sargon";
			case 40:
				return "Xerxes";
			case 41:
				return "Mulwatallish";
			case 42:
				return "Labarna";
			case 43:
				return "Hammurabi";
			case 44:
				return "Rameses";
			case 45:
				return "Minos";
			case 46:
				return "Tilgath-Pileser";
			case 47:
				return "Vercingetorix";
			case 48:
				return "Mithradites";
			case 49:
				return "Pericles";
			case 50:
				return "Belasarius";
			case 51:
				return "Archaemides";
			case 52:
				return "Heraclius";
			case 53:
				return "Imhotep";
			case 54:
				return "Artemis";
			case 55:
				return "Orthia";
			case 56:
				return "Phoebe";
			case 57:
				return "Hestia";
			case 58:
				return "Eros";
			case 59:
				return "Persephone";
			case 60:
				return "Minerva";
			case 61:
				return "Mercury";
			case 62:
				return "Aesculapius";
			case 63:
				return "Discordia";
			case 64:
				return "Hecate";
			case 65:
				return "Hespera";
		}
		return null;
	}
	
	public static String getRandomGodAdjective() {
		int random = getRangedRandom(1, 37);
		
		switch(random) {
			case 1:
				return "Almighty";
			case 2:
				return "Unthinkable";
			case 3:
				return "Unknowable";
			case 4:
				return "All-knowing";
			case 5:
				return "All-seeing";
			case 6:
				return "Lecherous";
			case 7:
				return "Scandalous";
			case 8:
				return "Merciful";
			case 9:
				return "Ravaging";
			case 10:
				return "Thunderous";
			case 11:
				return "Wrathful";
			case 12:
				return "Distant";
			case 13:
				return "Vengeful";
			case 14:
				return "Supreme";
			case 15:
				return "Wise";
			case 16:
				return "Warlike";
			case 17:
				return "Jealous";
			case 18:
				return "Vindictive";
			case 19:
				return "Powerful";
			case 20:
				return "Adulterous";
			case 21:
				return "Licentious";
			case 22:
				return "Crafty";
			case 23:
				return "Benefical";
			case 24:
				return "Virtuous";
			case 25:
				return "Protective";
			case 26:
				return "Prophetic";
			case 27:
				return "Bloodthirsty";
			case 28:
				return "Murderous";
			case 29:
				return "Ruinous";
			case 30:
				return "Militant";
			case 31:
				return "Invisible";
			case 32:
				return "Omnipotent";
			case 33:
				return "Forgotten";
			case 34:
				return "Enlightened";
			case 35:
				return "Tempestuous";
			case 36:
				return "Destructive";
			case 37:
				return "Grim";
		}
		return null;
	}
	
	public static String getRandomBodyPart() {
		int random = getRangedRandom(1, 18);
		
		switch(random) {
			case 1:
				return "Beard";
			case 2:
				return "Third Leg";
			case 3:
				return "Scalp";
			case 4:
				return "Eye";
			case 5:
				return "Thigh";
			case 6:
				return "Arm";
			case 7:
				return "Sword";
			case 8:
				return "Heel";
			case 9:
				return "Gaze";
			case 10:
				return "Tongue";
			case 11:
				return "Hammer";
			case 12:
				return "Toenail";
			case 13:
				return "Nether Regions";
			case 14:
				return "Liver";
			case 15:
				return "Lights";
			case 16:
				return "Spleen";
			case 17:
				return "Gall";
			case 18:
				return "Liver and Lights";
		}
		return null;
	}
	
	public static String getRandomBodyAdjective() {
		int random = getRangedRandom(1, 66);
		
		switch(random) {
			case 1:
				return "Unknowable";
			case 2:
				return "Unesecapable";
			case 3:
				return "Unfathomable";
			case 4:
				return "Unthinkable";
			case 5:
				return "Righteous";
			case 6:
				return "Hairy";
			case 7:
				return "Hairless";
			case 8:
				return "Wandering";
			case 9:
				return "Blistered";
			case 10:
				return "Awe-inspiring";
			case 11:
				return "Toothy";
			case 12:
				return "Ravaged";
			case 13:
				return "Aged";
			case 14:
				return "Endless";
			case 15:
				return "Wondrous";
			case 16:
				return "Unavoidable";
			case 17:
				return "Pestilent";
			case 18:
				return "Forgotten";
			case 19:
				return "Beautiful";
			case 20:
				return "Fertile";
			case 21:
				return "Prophetic";
			case 22:
				return "Musical";
			case 23:
				return "Helpful";
			case 24:
				return "Virginal";
			case 25:
				return "Curative";
			case 26:
				return "Bleak";
			case 27:
				return "Incessant";
			case 28:
				return "Sagely";
			case 29:
				return "Unfashionable";
			case 30:
				return "Unfaltering";
			case 31:
				return "Unfamiliar";
			case 32:
				return "Abysmal";
			case 33:
				return "Boundless";
			case 34:
				return "Eternal";
			case 35:
				return "Immeasurable";
			case 36:
				return "Infinite";
			case 37:
				return "Unending";
			case 38:
				return "Soundless";
			case 39:
				return "Incomprehensible";
			case 40:
				return "Inexplicable";
			case 41:
				return "Profound";
			case 42:
				return "Unintelligible";
			case 43:
				return "Unbelievable";
			case 44:
				return "Impenetrable";
			case 45:
				return "Indecipherable";
			case 46:
				return "Esoteric";
			case 47:
				return "Enigmatic";
			case 48:
				return "Ancient";
			case 49:
				return "Venerable";
			case 50:
				return "Baneful";
			case 51:
				return "Contagious";
			case 52:
				return "Corrupting";
			case 53:
				return "Deadly";
			case 54:
				return "Deleterious";
			case 55:
				return "Evil";
			case 56:
				return "Noxious";
			case 57:
				return "Diseased";
			case 58:
				return "Pernicious";
			case 59:
				return "Pestiferous";
			case 60:
				return "Pestilential";
			case 61:
				return "Tainted";
			case 62:
				return "Contaminated";
			case 63:
				return "Pulchritudinous";
			case 64:
				return "Oderiferous";
			case 65:
				return "Misbegotten";
			case 66:
				return "Sacriligious";
		}
		return null;
	}
	
	public static String getRandomReplacedWord(String type) {
		if (type == "food") {
			int random = getRangedRandom(1, 5);
			
			switch(random) {
				case 1:
					return " vittles";
				case 2:
					return " rations";
				case 3:
					return " sustenance";
				case 4:
					return " viands";
				case 5:
					return " nutriments";
			}
		} else if (type == "assist") {
			int random = getRangedRandom(1, 5);
			
			switch(random) {
				case 1:
					return " aid";
				case 2:
					return " aideth";
				case 3:
					return " saveth";
				case 4:
					return " assistance";
				case 5:
					return " succor";
			}
		} else if (type == "wow") {
			int random = getRangedRandom(1, 5);
			
			switch(random) {
				case 1:
					return " Marry";
				case 2:
					return " Faith";
				case 3:
					return " S'wounds";
				case 4:
					return " " + YeOldeMessageDatabase.getRandomGod() + "'s wounds";
				case 5:
					return " Zounds";
			}
		} else if (type == "afk") {
			int random = getRangedRandom(1, 4);
			
			switch(random) {
				case 1:
					return " away, fighting kobolds";
				case 2:
					return " away, fruity knights";
				case 3:
					return " aft, frisking knickers";
				case 4:
					return " abaft, flailing knouts";
			}
		} else if (type == "thankyou") {
			int random = getRangedRandom(1, 4);
			
			switch(random) {
				case 1:
					return " many good thanks to you";
				case 2:
					return " thankee";
				case 3:
					return " kindly thanks to you";
				case 4:
					return " grammercy to you";
			}
		} else if (type == "sell") {
			int random = getRangedRandom(1, 4);
			
			switch(random) {
				case 1:
					return " hawk";
				case 2:
					return " pawn";
				case 3:
					return " tender";
				case 4:
					return " purvey";
			}
		} else if (type == "buy") {
			int random = getRangedRandom(1, 2);
			
			switch(random) {
				case 1:
					return " purchase";
				case 2:
					return " obtain";
			}
		} else if (type == "maybe") {
			int random = getRangedRandom(1, 2);
			
			switch(random) {
				case 1:
					return " mayhaps";
				case 2:
					return " perchance";
			}
		} else if (type == "ok") {
			int random = getRangedRandom(1, 4);
			
			switch(random) {
				case 1:
					return " as you will";
				case 2:
					return " agreed";
				case 3:
					return " well said";
				case 4:
					return " just so";
			}
		} else if (type == "party") {
			int random = getRangedRandom(1, 4);
			
			switch(random) {
				case 1:
					return " band";
				case 2:
					return " fellowship";
				case 3:
					return " assembly";
				case 4:
					return " troop";
			}
		} else if (type == "water") {
			int random = getRangedRandom(1, 4);
			
			switch(random) {
				case 1:
					return " ale";
				case 2:
					return " mead";
				case 3:
					return " flagon of ale";
				case 4:
					return " flagon of mead";
			}
		} else if (type == "wait") {
			int random = getRangedRandom(1, 4);
			
			switch(random) {
				case 1:
					return " hold";
				case 2:
					return " hold hard";
				case 3:
					return " mark time";
				case 4:
					return " tarry";
			}
		} else if (type == "need") {
			int random = getRangedRandom(1, 4);
			
			switch(random) {
				case 1:
					return " covet";
				case 2:
					return " wish";
				case 3:
					return " desire";
				case 4:
					return " request";
			}
		} else if (type == "flag") {
			int random = getRangedRandom(1, 4);
			
			switch(random) {
				case 1:
					return " pennant";
				case 2:
					return " banner";
				case 3:
					return " colors";
				case 4:
					return " heraldry";
			}
		} else if (type == "vendor") {
			int random = getRangedRandom(1, 4);
			
			switch(random) {
				case 1:
					return " shopkeep";
				case 2:
					return " monger";
				case 3:
					return " merchant";
				case 4:
					return " purveyor";
			}
		} else if (type == "debuff") {
			int random = getRangedRandom(1, 3);
			
			switch(random) {
				case 1:
					return " ailment";
				case 2:
					return " sickness";
				case 3:
					return " pox";
			}
		} else if (type == "thank") {
			int random = getRangedRandom(1, 3);
			
			switch(random) {
				case 1:
					return " many good thank";
				case 2:
					return " thankee";
				case 3:
					return " kindly thank";
			}
		} else if (type == "please") {
			int random = getRangedRandom(1, 3);
			
			switch(random) {
				case 1:
					return " I pray you";
				case 2:
					return " prithee";
				case 3:
					return " pray";
			}
		} else if (type == "you") {
			int random = getRangedRandom(1, 3);
			
			switch(random) {
				case 1:
					return " thou";
				case 2:
					return " thee";
				case 3:
					return " ye";
			}
		} else if (type == "your") {
			int random = getRangedRandom(1, 3);
			
			switch(random) {
				case 1:
					return " thy";
				case 2:
					return " thine";
				case 3:
					return " thyne";
			}
		} else if (type == "yes") {
			int random = getRangedRandom(1, 3);
			
			switch(random) {
				case 1:
					return " aye";
				case 2:
					return " yea";
				case 3:
					return " yea verily";
			}
		} else if (type == "level") {
			int random = getRangedRandom(1, 2);
			
			switch(random) {
				case 1:
					return " rank";
				case 2:
					return " station";
			}
		} else if (type == "no") {
			int random = getRangedRandom(1, 2);
			
			switch(random) {
				case 1:
					return " nay";
				case 2:
					return " nayeth";
			}
		} else if (type == "joke") {
			int random = getRangedRandom(1, 2);
			
			switch(random) {
				case 1:
					return " jest";
				case 2:
					return " jape";
			}
		} else if (type == "will") {
			int random = getRangedRandom(1, 2);
			
			switch(random) {
				case 1:
					return " wilt";
				case 2:
					return " wouldst";
			}
		} else if (type == "really") {
			int random = getRangedRandom(1, 2);
			
			switch(random) {
				case 1:
					return " indeed";
				case 2:
					return " in truth";
			}
		} else if (type == "lol") {
			int random = getRangedRandom(1, 2);
			
			switch(random) {
				case 1:
					return " lolleth";
				case 2:
					return " lollery";
			}
		} else if (type == "town") {
			int random = getRangedRandom(1, 7);
			
			switch(random) {
				case 1:
					return " borough";
				case 2:
					return " burgage";
				case 3:
					return " burgh";
				case 4:
					return " keep";
				case 5:
					return " castle";
				case 6:
					return " hamlet";
				case 7:
					return " redoubt";
			}
		} else if (type == "money") {
			int random = getRangedRandom(1, 8);
			
			switch(random) {
				case 1:
					return " bullion";
				case 2:
					return " florins";
				case 3:
					return " pounds";
				case 4:
					return " ducats";
				case 5:
					return " pieces o'silver";
				case 6:
					return " groats";
				case 7:
					return " crowns";
				case 8:
					return " ingots";
			}
		} else if (type == "balls") {
			int random = getRangedRandom(1, 8);
			
			switch(random) {
				case 1:
					return " leathers";
				case 2:
					return " beans";
				case 3:
					return " poundables";
				case 4:
					return " nethers";
				case 5:
					return " nadchakles";
				case 6:
					return " buis";
				case 7:
					return " fellahs";
				case 8:
					return " coin purse";
			}
		} else if (type == "girl") {
			int random = getRangedRandom(1, 8);
			
			switch(random) {
				case 1:
					return " madame";
				case 2:
					return " waif";
				case 3:
					return " mistress";
				case 4:
					return " lass";
				case 5:
					return " lady";
				case 6:
					return " goodwife";
				case 7:
					return " maid";
				case 8:
					return " maiden";
			}
		} else if (type == "kill") {
			int random = getRangedRandom(1, 9);
			
			switch(random) {
				case 1:
					return " slay";
				case 2:
					return " vanquish";
				case 3:
					return " bring low";
				case 4:
					return " conquer";
				case 5:
					return " fleece";
				case 6:
					return " humble";
				case 7:
					return " subjugate";
				case 8:
					return " best";
				case 9:
					return " foil";
			}
		} else if (type == "killed") {
			int random = getRangedRandom(1, 9);
			
			switch(random) {
				case 1:
					return " slain";
				case 2:
					return " vanquished";
				case 3:
					return " brung low";
				case 4:
					return " conquered";
				case 5:
					return " fleeced";
				case 6:
					return " humbled";
				case 7:
					return " subjugated";
				case 8:
					return " bested";
				case 9:
					return " foiled";
			}
		} else if (type == "friend") {
			int random = getRangedRandom(1, 10);
			
			switch(random) {
				case 1:
					return " companion";
				case 2:
					return " boon companion";
				case 3:
					return " chum";
				case 4:
					return " lad";
				case 5:
					return " cohort";
				case 6:
					return " confidant";
				case 7:
					return " right-hand man";
				case 8:
					return " mate";
				case 9:
					return " compadre";
				case 10:
					return " fellow";
			}
		} else if (type == "!") {
			int random = getRangedRandom(1, 11);
			
			switch(random) {
				case 1:
					return ", verily!";
				case 2:
					return ", verily I say!";
				case 3:
					return ", verily I sayeth!";
				case 4:
					return ", I say!";
				case 5:
					return ", I sayeth!";
				case 6:
					return "! Huzzah!";
				case 7:
					return "! Hear Hear!";
				case 8:
					return "! What-ho!";
				case 9:
					return "! Ho!";
				case 10:
					return "! Fie!";
				case 11:
					return ", indeed!";
			}
		} else if (type == "hello") {
			int random = getRangedRandom(1, 5);
			
			switch(random) {
				case 1:
					return " good day";
				case 2:
					return " well met";
				case 3:
					return " well metteth";
				case 4:
					return " tally ho";
				case 5:
					return " ave";
			} 
		} else if (type == "shop") {
			int random = getRangedRandom(1, 6);
			
			switch(random) {
				case 1:
					return " shoppe";
				case 2:
					return " shopcart";
				case 3:
					return " olde shoppe";
				case 4:
					return " market";
				case 5:
					return " marketplace";
				case 6:
					return " ye olde thrifte shoppe";
			} 
		} else if (type == "noob") {
			int random = getRangedRandom(1, 13);
			
			switch(random) {
				case 1:
					return " neophyte";
				case 2:
					return " youngster";
				case 3:
					return " serf";
				case 4:
					return " dabbler";
				case 5:
					return " pleb";
				case 6:
					return " apprentice";
				case 7:
					return " journeyman";
				case 8:
					return " pupil";
				case 9:
					return " tenderfoot";
				case 10:
					return " initiate";
				case 11:
					return " fledgling";
				case 12:
					return " greenhorn";
				case 13:
					return " acolyte";
			} 
		} else if (type == "?") {
			int random = getRangedRandom(1, 13);
			
			switch(random) {
				case 1:
					return ", I say?";
				case 2:
					return ", I wonder?";
				case 3:
					return ", wonder I?";
				case 4:
					return ", what say thee?";
				case 5:
					return ", what sayeth thee?";
				case 6:
					return ", what say thou?";
				case 7:
					return ", what sayeth thou?";
				case 8:
					return ", I ponder?";
				case 9:
					return ", I pondereth?";
				case 10:
					return ", pray tell?";
				case 11:
					return ", ho?";
				case 12:
					return ", do tell?";
				case 13:
					return "?";
			} 
		} else if (type == "bye") {
			int random = getRangedRandom(1, 15);
			
			switch(random) {
				case 1:
					return " farewell";
				case 2:
					return " fare thee well";
				case 3:
					return " good morrow";
				case 4:
					return " by your leave";
				case 5:
					return " godspeed";
				case 6:
					return " begone";
				case 7:
					return " good day";
				case 8:
					return " good day, sirrah";
				case 9:
					return " good day, sire";
				case 10:
					return " good day, master";
				case 11:
					return " adieu";
				case 12:
					return " cheerio";
				case 13:
					return " pleasant journey";
				case 14:
					return " I bid thee good day";
				case 15:
					return " I bid thee farewell";
			} 
		} else if (type == "haha") {
			int random = getRangedRandom(1, 16);
			
			switch(random) {
				case 1:
					return " guffaw!";
				case 2:
					return " cackle!";
				case 3:
					return " oh, 'tis to laugh!";
				case 4:
					return " zounds!";
				case 5:
					return " chuckle!";
				case 6:
					return " snigger!";
				case 7:
					return " snort!";
				case 8:
					return " snicker!";
				case 9:
					return " catchinnate!";
				case 10:
					return " titter!";
				case 11:
					return " and there was much tittering!";
				case 12:
					return " and there was much guffawing!";
				case 13:
					return " and there was much chuckling!";
				case 14:
					return " and there was much snorting!";
				case 15:
					return " and there was much snickering!";
				case 16:
					return " and there was much mirth!";
			} 
		} else if (type == "insult-prepend") {
			int random = getRangedRandom(1, 53);
			
			switch(random) {
				case 1:
					return " artless";
				case 2:
					return " droning";
				case 3:
					return " fawning";
				case 4:
					return " warped";
				case 5:
					return " paunchy";
				case 6:
					return " puny";
				case 7:
					return " spongy";
				case 8:
					return " ruttish";
				case 9:
					return " vain";
				case 10:
					return " lumpish";
				case 11:
					return " craven";
				case 12:
					return " witless";
				case 13:
					return " pustulent";
				case 14:
					return " infested";
				case 15:
					return " ill-bred";
				case 16:
					return " blind";
				case 17:
					return " scurvy";
				case 18:
					return " puny";
				case 19:
					return " fetid";
				case 20:
					return " vile";
				case 21:
					return " gibbering";
				case 22:
					return " mewling";
				case 23:
					return " rank";
				case 24:
					return " fawning";
				case 25:
					return " moonish";
				case 26:
					return " brutish";
				case 27:
					return " malapert";
				case 28:
					return " curst";
				case 29:
					return " lack-linen";
				case 30:
					return " bottle-ailed";
				case 31:
					return " lyingest";
				case 32:
					return " embossed";
				case 33:
					return " cheating";
				case 34:
					return " crook-pated";
				case 35:
					return " base-court";
				case 36:
					return " hasty-witted";
				case 37:
					return " two-faced";
				case 38:
					return " pox-marked";
				case 39:
					return " toad-brained";
				case 40:
					return " errant";
				case 41:
					return " idle-headed";
				case 42:
					return " quailing";
				case 43:
					return " flap-mouthed";
				case 44:
					return " puking";
				case 45:
					return " fly-bitted";
				case 46:
					return " surly";
				case 47:
					return " tottering";
				case 48:
					return " villainous";
				case 49:
					return " rump-fed";
				case 50:
					return " bootless";
				case 51:
					return " churlish";
				case 52:
					return " tickle-brained";
				case 53:
					return " froward";
			} 
		}  else if (type == "insult") {
			int random = getRangedRandom(1, 42);
			
			switch(random) {
				case 1:
					return " mongrel";
				case 2:
					return " codpiece";
				case 3:
					return " jackanape";
				case 4:
					return " ape";
				case 5:
					return " coxcomb";
				case 6:
					return " harlot";
				case 7:
					return " hussy";
				case 8:
					return " strumpet";
				case 9:
					return " cur";
				case 10:
					return " clot";
				case 11:
					return " fool";
				case 12:
					return " barnacle";
				case 13:
					return " harpy";
				case 14:
					return " wench";
				case 15:
					return " churl";
				case 16:
					return " pleb";
				case 17:
					return " taffer";
				case 18:
					return " scoundrel";
				case 19:
					return " scalliwag";
				case 20:
					return " mooncalf";
				case 21:
					return " rapscallion";
				case 22:
					return " doxy";
				case 23:
					return " bawd";
				case 24:
					return " tosspot";
				case 25:
					return " cupshot";
				case 26:
					return " recreant";
				case 27:
					return " fustalarion";
				case 28:
					return " scullion";
				case 29:
					return " rampallion";
				case 30:
					return " knave";
				case 31:
					return " barbermonger";
				case 32:
					return " boil";
				case 33:
					return " plague-sore";
				case 34:
					return " carbuncle";
				case 35:
					return " whoreson";
				case 36:
					return " clotpole";
				case 37:
					return " lout";
				case 38:
					return " gudgeon";
				case 39:
					return " puttock";
				case 40:
					return " skainsmate";
				case 41:
					return " varlet";
				case 42:
					return " bladder";
			} 
		}
		return null;
	}

}
