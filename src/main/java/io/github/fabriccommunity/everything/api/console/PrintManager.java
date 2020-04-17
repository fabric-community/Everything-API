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

package io.github.fabriccommunity.everything.api.console;

import io.github.fabriccommunity.everything.api.annotation.CentaConsumer;

public class PrintManager implements PrintConsumer<String>, CentaConsumer<String, String, String, String, String, String, String, String, String, String, String, String, String, String, String, String, String, String, String, String, String, String, String,
                                                                String, String, String, String, String, String, String, String, String, String, String, String, String, String, String, String, String, String, String, String, String, String, String,
                                                                String, String, String, String, String, String, String, String, String, String, String, String, String, String, String, String, String, String, String, String, String, String, String,
                                                                String, String, String, String, String, String, String, String, String, String, String, String, String, String, String, String, String, String, String, String, String, String, String,
                                                                String, String, String, String, String, String, String, String> {

	@Override
	public void accept(String readFromConsole) {
		System.out.println(readFromConsole);
	}

	@Override
	public void accept(String o, String o2, String o3, String o4, String o5, String o6, String o7, String o8, String o9, String o10, String o11, String o12, String o13, String o14, String o15, String o16, String o17, String o18, String o19, String o20,
	                   String o21, String o22, String o23, String o24, String o25, String o26, String o27, String o28, String o29, String o30, String o31, String o32, String o33, String o34, String o35, String o36, String o37, String o38, String o39,
	                   String o40, String o41, String o42, String o43, String o44, String o45, String o46, String o47, String o48, String o49, String o50, String o51, String o52, String o53, String o54, String o55, String o56, String o57, String o58,
	                   String o59, String o60, String o61, String o62, String o63, String o64, String o65, String o66, String o67, String o68, String o69, String o70, String o71, String o72, String o73, String o74, String o75, String o76, String o77,
	                   String o78, String o79, String o80, String o81, String o82, String o83, String o84, String o85, String o86, String o87, String o88, String o89, String o90, String o91, String o92, String o93, String o94, String o95, String o96,
	                   String o97, String o98, String o99, String o100) {
		System.out.printf("%s%s%s%s%s%s%s%s%s%s%s%s%s%s%s%s%s%s%s%s%s%s%s%s%s%s%s%s%s%s%s%s%s%s%s%s%s%s%s%s%s%s%s%s%s%s%s%s%s%s%s%s%s%s%s%s%s%s%s%s%s%s%s%s%s%s%s%s%s%s%s%s%s%s%s%s%s%s%s%s%s%s%s%s%s%s%s%s%s%s%s%s%s%s%s%s%s%s%s%s", o, o2, o3, o4, o5, o6,
		                  o7, o8, o9, o10, o11, o12, o13, o14, o15, o16, o17, o18, o19, o20, o21, o22, o23, o24, o25, o26, o27, o28, o29, o30, o31, o32, o33, o34, o35, o36, o37, o38, o39, o40, o41, o42, o43, o44, o45, o46, o47, o48, o49, o50, o51, o52,
		                  o53, o54, o55, o56, o57, o58, o59, o60, o61, o62, o63, o64, o65, o66, o67, o68, o69, o70, o71, o72, o73, o74, o75, o76, o77, o78, o79, o80, o81, o82, o83, o84, o85, o86, o87, o88, o89, o90, o91, o92, o93, o94, o95, o96, o97, o98
		, o99, o100);
	}
}
