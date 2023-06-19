package domain;

public enum AcompanamientoExtra {
  QUESO(5),
  TOCINO(7),
  PEPINILLOS(6.5),
  SIN_COMPLENTO(0);

  private final double price;

  private AcompanamientoExtra(double price) {
    this.price = price;
  }

  public double getPrice() {
    return price;
  }
}
