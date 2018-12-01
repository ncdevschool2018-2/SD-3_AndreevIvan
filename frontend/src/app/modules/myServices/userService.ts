export class UserService {
  private daysLeft: number;
  private status: string;
  private name: string;
  private basePrice: number;


  constructor(daysLeft: number, status: string, name: string, priceForPeriod: number) {
    this.daysLeft = daysLeft;
    this.status = status;
    this.name = name;
    this.basePrice = priceForPeriod;
  }
}
