export class Service {
  id: number;
  name: string;
  description: string;
  basePrice: string;


  constructor(id: number, name: string, basePrice: string, description: string) {
    this.id = id;
    this.name = name;
    this.description = description;
    this.basePrice = basePrice;
  }
}
