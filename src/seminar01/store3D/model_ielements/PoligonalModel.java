package seminar01.store3D.model_ielements;

import java.util.List;

public class PoligonalModel {
    private List<Poligon> poligons;
    private Texture texture;

    public PoligonalModel(List<Poligon> poligons, Texture texture) {
        this.poligons = poligons;
        this.texture = texture;
    }

    public PoligonalModel(List<Poligon> poligons) {
        this.poligons = poligons;
    }
}
