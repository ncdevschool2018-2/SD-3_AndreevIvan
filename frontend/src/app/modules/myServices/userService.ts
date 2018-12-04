export class UserService {
  private subPeriod: number;
  private daysLeft: number;
  private status: string;
  private name: string;
  private basePrice: number;


  constructor(daysLeft: number, status: string, name: string, basePrice: number, subPeriod: number) {
    this.subPeriod = subPeriod;
    this.daysLeft = daysLeft;
    this.status = status;
    this.name = name;
    this.basePrice = basePrice;
  }
}
