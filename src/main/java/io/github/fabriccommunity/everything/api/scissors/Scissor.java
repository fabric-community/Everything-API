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
