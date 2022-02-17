import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { EnrolledlistService } from '../../utility/enrolledlist.service';
import { saveAs as importedSaveAs } from "file-saver";

@Component({
  selector: 'app-view-material',
  templateUrl: './view-material.component.html',
  styleUrls: ['./view-material.component.scss']
})
export class ViewMaterialComponent implements OnInit {
  technologyid: any;
  material: any[];
  constructor(private _activeroute: ActivatedRoute,
    private _enrolledlistservice: EnrolledlistService,
    private _toaster: ToastrService) {

    this._activeroute.params.subscribe(data => {
      this.technologyid = data.id;
    })


  }

  ngOnInit() {
    this.viewMaterial();
  }

  viewMaterial() {
    this._enrolledlistservice.viewAllTutorMaterial(this.technologyid).subscribe(data => {
      if (data != null)
        this.material = data;
      else
        this._toaster.error("Something went wrong")
    })
  }

  downloadMaterial(materialId: number, i: number) {
    this._enrolledlistservice.downloadMaterial(materialId).subscribe(data => {
      if (data != null) {
        importedSaveAs(data, this.material[i].fileName + '.' + this.material[i].fileType);
        this._toaster.success("File successfully Downloaded")
      }
      else
        this._toaster.error("File not found");
    })
  }

}


