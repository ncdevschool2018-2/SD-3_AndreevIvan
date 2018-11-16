import {Service} from '../serviceCatalogue/service';

export class Profile {
  login: string;
  email: string;
  tokens: number;
  password: string;
  status: string;
  services: Service[];

  constructor(login: string, email: string, tokens: number, password: string, status: string) {
    this.login = login;
    this.email = email;
    this.tokens = tokens;
    this.password = password;
    this.status = status;
  }
}
