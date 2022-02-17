import { Pipe, PipeTransform } from '@angular/core';
import { IEnrollTutor } from './ienroll-tutor';
import { ITutor } from './itutor';

@Pipe({
  name: 'searchByNameAndTechnology'
})
export class SearchByTutorNameAndTechnologyPipe implements PipeTransform {

  transform(value: IEnrollTutor[], args: any): any {
    if (!value) {
      return []
    }
    if (!args) {
      return value;
    }
    return value.filter(tutor => {
      //return JSON.stringify(tutor).toLowerCase().includes(args.toLowerCase())
      return tutor.tutor.belongsToTutor.username.toLowerCase().includes(args.toLocaleLowerCase())
        || tutor.tutor.technologyname.toLowerCase().includes(args.toLocaleLowerCase())
        || tutor.feedback >= args
    })
  }
}