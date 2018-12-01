export class Service {
  private name: string;
  private description: string;
  private basePrice: string;


  constructor(name: string, basePrice: string, description: string) {
    this.name = name;
    this.description = description;
    this.basePrice = basePrice;
  }
}
