package fr.natsystem.tp.data.utilities;

public enum CouleurEnum {
	ROUGE_ENUM("Rouge"),
	ROSE_ENUM("Ros�"),
	BLANC_ENUM("Blanc"),
	CHAMPAGNE_ENUM("Champagne"),
	LIQUOREUX_ENUM("Liquoreux"),
	BIERE_ENUM("Bi�re"),
	CIDRE_ENUM("Cidre"),
	SIRITUEUX_ENUM("Spiritueux");

    private final String name;

	CouleurEnum(String couleur) { this.name = couleur; }
    public String getName() {
        return name;
    }
    @Override
    public String toString() {
        return this.name;
    }


    public static CouleurEnum getEnum(String value) {
        for (CouleurEnum v : values())
            if (v.toString().equalsIgnoreCase(value)) return v;
        throw new IllegalArgumentException();
    }

}
