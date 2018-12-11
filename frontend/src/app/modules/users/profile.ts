import {Service} from '../serviceCatalogue/service';
import {UserService} from '../myServices/userService';

export class Profile {
  id: number;
  login: string;
  email: string;
  tokens: number;
  password: string;
  status: string;
  role: number;
  userServices: UserService[];

  constructor(id: number, login: string, email: string, tokens: number,
              password: string, status: string, role: number, userServices: UserService[]) {
    this.id = id;
    this.login = login;
    this.email = email;
    this.tokens = tokens;
    this.password = password;
    this.status = status;
    this.role = role;
    this.userServices = userServices;
  }
}
