import {UserService} from '../myServices/userService';

export class Service {
  id: number;
  name: string;
  description: string;
  basePrice: string;
  userServices: UserService[];


  constructor(id: number, name: string, basePrice: string, description: string, userServices: UserService[]) {
    this.id = id;
    this.name = name;
    this.description = description;
    this.basePrice = basePrice;
    this.userServices = userServices;
  }
}
