import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { ToastrService } from 'ngx-toastr';
import { StudentService } from '../../utility/student.service';
import { ValidatorService } from 'src/app/auth/utility/validator.service';

@Component({
  selector: 'app-changepassword',
  templateUrl: './changepassword.component.html',
  styleUrls: ['./changepassword.component.scss']
})
export class ChangepasswordComponent implements OnInit {
  password: any="";
  confirmPassword=''
  changePasswordForm: FormGroup;
  submitted = false;
  
  constructor(private toastr: ToastrService,
    private _studentService: StudentService,
    private modal: NgbActiveModal,
    private fb: FormBuilder,
    private _validatserv : ValidatorService
  ) { 
    this.changePasswordForm=this.fb.group({
      password:['',Validators.compose([Validators.required,_validatserv.patternValidator()])],
      confirmPassword:['',Validators.compose([Validators.required,_validatserv.patternValidator()])]
    },
    {  
      validator: this._validatserv.MatchPassword('password', 'confirmPassword'),  
    }
    )
  }

  ngOnInit(): void {
    
  }

  get f() {
    return this.changePasswordForm.controls; 
  }

  onUpdate(changepassword: FormGroup) {
    this.submitted = true;
    if (this.changePasswordForm.invalid) {
      return;
    }
    this._studentService.changePassword(changepassword.value)
    .subscribe(response => {
      if (response!=null) {
        this.toastr.success("password changed successfully")
        this.modal.dismiss('ok')
      } else {
        this.toastr.error(response['error'])
      }
    })
  }

  onCancel() {
    this.modal.dismiss('cancel')
  }
}
