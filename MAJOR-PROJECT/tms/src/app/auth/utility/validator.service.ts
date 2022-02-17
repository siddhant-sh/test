import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { AbstractControl, FormGroup, ValidatorFn } from '@angular/forms';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { AuthService } from './auth.service';


@Injectable({
  providedIn: 'root'
})
export class ValidatorService {

  isExist;
  constructor(
    private _authserv: AuthService,
    private _http: HttpClient
  ) { }

  patternValidator(): ValidatorFn {
    return (control: AbstractControl): { [key: string]: any } => {
      if (!control.value) {
        return null;
      }
      const regex = new RegExp('^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9]).{8,}$');
      const valid = regex.test(control.value);
      return valid ? null : { invalidPassword: true };
    };
  }


  MatchPassword(password: string, confirmPassword: string) {
    return (formGroup: FormGroup) => {
      const passwordControl = formGroup.controls[password];
      const confirmPasswordControl = formGroup.controls[confirmPassword];

      if (!passwordControl || !confirmPasswordControl) {
        return null;
      }

      if (confirmPasswordControl.errors && !confirmPasswordControl.errors.passwordMismatch) {
        return null;
      }

      if (passwordControl.value !== confirmPasswordControl.value) {
        confirmPasswordControl.setErrors({ passwordMismatch: true });
      } else {
        confirmPasswordControl.setErrors(null);
      }
    }
  }

  emailValidator(emailControl: AbstractControl) {
    return new Promise(resolve => {
      setTimeout(async () => {
        this.isExist = await this.checkMailExist(emailControl.value);
        if (this.isExist) {
          emailControl.setErrors({ emailNotAvailable: true })
        } else {
          resolve(null);
        }
      }, 1000);
    });
  }

  checkMailExist(email: String): Promise<any> {
    const body = {
      email: email
    }
    return this._http.post<any>('http://localhost:9090/checkemail', body).toPromise();
  }

  MatchEmail(email: string, newEmail: string) {
    return (formGroup: FormGroup) => {
      const newEmailControl = formGroup.controls[newEmail];
      if (!newEmailControl) {
        return null;
      }
      if (newEmailControl.errors) {
        return null;
      }
      if (email != newEmailControl.value) {
        this.emailValidator(newEmailControl)
      } else {
        newEmailControl.setErrors(null);
      }
    }
  }
}
