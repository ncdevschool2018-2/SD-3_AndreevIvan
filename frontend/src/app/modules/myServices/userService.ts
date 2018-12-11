export class UserService {
  id: number;
  subPeriod: number;
  daysLeft: number;
  status: number;
  name: string;
  basePrice: number;
  subVariant: number;
  userId: number;
  serviceId: number;


  constructor(daysLeft: number, status: number, name: string, basePrice: number, subPeriod: number,
              userId: number, serviceId: number, id: number, subVariant: number) {
    this.subPeriod = subPeriod;
    this.daysLeft = daysLeft;
    this.status = status;
    this.name = name;
    this.basePrice = basePrice;
    this.serviceId = serviceId;
    this.userId = userId;
    this.id = id;
    this.subVariant = subVariant;
  }
}
