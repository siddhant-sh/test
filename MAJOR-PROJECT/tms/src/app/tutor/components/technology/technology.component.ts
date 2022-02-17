import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { TechnologyService } from '../../utility/technology.service';

@Component({
  selector: 'app-technology',
  templateUrl: './technology.component.html',
  styleUrls: ['./technology.component.scss']
})
export class TechnologyComponent implements OnInit {

  techForm: FormGroup;
  submitted = false;
  technologies: any;
  constructor(
    private _techServ: TechnologyService,
    private fb: FormBuilder,
    private _toaster: ToastrService,
    private _router: Router
  ) {
    this.techForm = this.fb.group({
      technologyname: ['', Validators.required],
    })
  }

  ngOnInit(): void {
    this.getAllTechnologiesForTutor();
  }

  getAllTechnologiesForTutor() {
    this._techServ.getTechnologyList().subscribe((data) => {
      if (data != null)
        this.technologies = data;
      else
        this._toaster.error("Something went Wrong")
    })
  }

  get f() { return this.techForm.controls; }
  onaddTech(technology: FormGroup) {
    this.submitted = true;

    // stop here if form is invalid
    if (this.techForm.invalid) {
      return;
    }
    this._techServ.addTechnology(technology.value.technologyname).subscribe((data) => {
      if (data != null){
        this._toaster.success(data.technologyname + " added successfully")
        this.ngOnInit();
      }
      else
        this._toaster.error("Technology adding failed")
    })
  }

  addMaterial(id: number) {
    this._router.navigate(['/tutorhome/tutor/material-add/' + id])
  }

  viewMaterial(id: number) {

    this._router.navigate(['/tutorhome/tutor/material-view/' + id])
  }
}
