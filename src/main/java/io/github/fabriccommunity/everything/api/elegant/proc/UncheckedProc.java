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

package io.github.fabriccommunity.everything.api.elegant.proc;

/**
 * An unchecked Proc.
 *
 * @param <A> the input type
 */
public final class UncheckedProc<A> implements Proc<A> {
    private final Proc<A> proc;

    public UncheckedProc(final Proc<A> proc) {
        this.proc = proc;
    }

    @Override
    public final void run(final A input) {
        try {
            proc.run(input);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
