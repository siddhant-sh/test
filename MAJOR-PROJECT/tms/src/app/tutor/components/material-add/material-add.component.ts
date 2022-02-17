import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { TechnologyService } from '../../utility/technology.service';

@Component({
  selector: 'app-material-add',
  templateUrl: './material-add.component.html',
  styleUrls: ['./material-add.component.scss']
})
export class MaterialAddComponent implements OnInit {

  technologyId: number
  materialForm: FormGroup;
  submitted = false;
  constructor(
    private _activeRoute: ActivatedRoute,
    private _techServ: TechnologyService,
    private fb: FormBuilder,
    private _toaster: ToastrService,
    private _router: Router
  ) {
    _activeRoute.params.subscribe(data => {
      this.technologyId = data.id
    })
    this.materialForm = this.fb.group({
      fileName: ['', Validators.required],
      file: ['', Validators.required],
      fileSource: ['', Validators.required]
    })
  }

  ngOnInit(): void {
  }

  onFileChange(event) {

    if (event.target.files.length > 0) {
      const file = event.target.files[0];
      this.materialForm.patchValue({
        fileSource: file
      });
    }
  }

  get f() { return this.materialForm.controls; }
  onAddMaterial(material: FormGroup) {
    this.submitted = true;
    // stop here if form is invalid
    if (this.materialForm.invalid) {
      return;
    }
    this._techServ.addMaterial(this.technologyId, material.value.fileName, material.get('fileSource').value).subscribe((data) => {
      if (data.materialid==0) {
        this._toaster.error("Material adding failed")
        this._router.navigate(['/tutorhome/tutor/technology'])
      }
      else{
        this._toaster.success("Material added successfully")
        this._router.navigate(['/tutorhome/tutor/material-view/' + this.technologyId])
      }
    })

  }
}
