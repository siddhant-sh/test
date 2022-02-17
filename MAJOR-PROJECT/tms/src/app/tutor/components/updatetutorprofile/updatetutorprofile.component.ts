import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { ToastrService } from 'ngx-toastr';
import { ValidatorService } from 'src/app/auth/utility/validator.service';
import { TutorService } from '../../utility/tutor.service';

@Component({
  selector: 'app-updatetutorprofile',
  templateUrl: './updatetutorprofile.component.html',
  styleUrls: ['./updatetutorprofile.component.scss']
})
export class UpdatetutorprofileComponent implements OnInit {

  username = ""
  email =  ""
  specialization = ""
  experience = ""
  updateProfileForm: FormGroup;
  submitted = false;

  constructor(private toastr: ToastrService,
  private modal: NgbActiveModal,
  private _tutorService: TutorService,
  private fb: FormBuilder,
  private _validatserv : ValidatorService
  ) {
    
  }

  ngOnInit(): void {
    this.updateProfileForm=this.fb.group({
      name:['',Validators.required],
      email:['',[Validators.required,Validators.email]],
      specialization:['',Validators.required],
      experience:['',Validators.required]
    },
    {  
      validator: this._validatserv.MatchEmail(this.email, 'email')  
    }
    )
    this.updateProfileForm.setValue({
      name:this.username,
      email:this.email,
      specialization:this.specialization,
      experience:this.experience
    })
  }

  get f() { return this.updateProfileForm.controls; }

  onUpdate(updateProfile: FormGroup) {
    this.submitted = true;
    if (this.updateProfileForm.invalid) {
      return;
    }
    this._tutorService.updateTutor(updateProfile.value)
      .subscribe(response => {
        if (response != null) {
          this.modal.dismiss('ok')
          this.toastr.success(this.username+" Profile updated successfully")
        } else {
          this.toastr.error(response['error'])
        }
      })
  }

  onCancel() {
    this.modal.dismiss('cancel')
  }

}
