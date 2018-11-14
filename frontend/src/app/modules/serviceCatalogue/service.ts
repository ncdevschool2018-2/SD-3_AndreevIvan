export class Service {
  private _name: string;
  private _description: string;
  private _basePrice: string;
  status: string;


  constructor(name: string, description: string, basePrice: string) {
    this._name = name;
    this._description = description;
    this._basePrice = basePrice;
  }
}
