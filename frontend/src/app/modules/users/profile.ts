import {Service} from '../serviceCatalogue/service';

export class Profile {
  id: number;
  login: string;
  email: string;
  tokens: number;
  password: string;
  status: number;
  role: number;

  constructor(id: number, login: string, email: string, tokens: number, password: string, status: number, role: number) {
    this.id = id;
    this.login = login;
    this.email = email;
    this.tokens = tokens;
    this.password = password;
    this.status = status;
    this.role = role;
  }
}
