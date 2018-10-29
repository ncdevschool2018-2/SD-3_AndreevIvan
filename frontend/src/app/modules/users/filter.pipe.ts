import {Pipe, PipeTransform} from '@angular/core';

@Pipe({name: 'filter'})
export class FilterPipe implements PipeTransform {
  transform(users: any[], filterQuery: string): any[] {
    return users
      .filter(user => user.name !== filterQuery);
  }
}
