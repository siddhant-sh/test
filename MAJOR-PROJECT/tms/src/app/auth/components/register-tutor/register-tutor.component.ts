import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { AuthService } from '../../utility/auth.service';
import { ValidatorService } from '../../utility/validator.service';

@Component({
  selector: 'app-register-tutor',
  templateUrl: './register-tutor.component.html',
  styleUrls: ['./register-tutor.component.scss']
})
export class RegisterTutorComponent implements OnInit {

  registerForm: FormGroup;
  submitted = false;
  constructor(
    private fb: FormBuilder,
    private _router:Router,
    private _authserv: AuthService,
    private _toaster : ToastrService,
    private _validatserv : ValidatorService
  ) {
    this.registerForm=this.fb.group({
      name:['',Validators.required],
      email:['',[Validators.required,Validators.email],this._validatserv.emailValidator.bind(this._validatserv)],
      password:['',Validators.compose([Validators.required,_validatserv.patternValidator()])],
      confirmPassword:['',Validators.compose([Validators.required,_validatserv.patternValidator()])],
      gender:['',Validators.required],
      specialization:['',Validators.required],
      experience:['',Validators.required],
    },
    {  
      validator: this._validatserv.MatchPassword('password', 'confirmPassword'),  
    }
    )
   }

  ngOnInit(): void {
  }

  get f() { return this.registerForm.controls; }

  
  onRegister(register: FormGroup) {
    this.submitted = true;
    
    // stop here if form is invalid
    if (this.registerForm.invalid) {
      return;
    }
    this._authserv.registerTutor(register.value)
      .subscribe(data => {
        this._toaster.success(" Successfully Register ")
        this._router.navigate(['/auth/login'])
      },
        HttpErrorResponse => {
          if (HttpErrorResponse.status == 401)
          this._toaster.error("Something went Wrong")
        }
      );

  }

}