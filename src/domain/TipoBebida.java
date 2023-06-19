package domain;

public enum TipoBebida {
  AGUA_SIMPLE(0),
  AGUA_FRESCA(15),
  EMBOTELLADO(20),
  CAFE(18),
  TE(18);

  private final double price;

  private TipoBebida(double price) {
    this.price = price;
  }

  public double getPrice() {
    return price;
  }
}
