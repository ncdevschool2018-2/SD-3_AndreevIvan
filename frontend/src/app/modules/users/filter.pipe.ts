import { Pipe, PipeTransform } from '@angular/core';
import {Profile} from './profile';


@Pipe({
  name: 'filter'
})
export class FilterPipe implements PipeTransform {
  transform(items: Profile[], searchText: string): any {

    if (!items) {
      return [];
    }
    if (!searchText) {
      return items;
    }
    searchText = searchText.toLocaleLowerCase();

    console.log(items.filter(it => {
      return it.login.toLocaleLowerCase().includes(searchText);
    }));
    return items.filter(it => {
      return it.login.toLocaleLowerCase().includes(searchText);
    });
  }
}
