package domain;

public enum TipoHamburgesa {
  SENCILLA(10),
  DOBLE(15),
  TRIPLE(25);

  private final double price;

  private TipoHamburgesa(double price) {
    this.price = price;
  }

  public double getPrice() {
    return price;
  }
}
