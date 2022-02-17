import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { TechnologyService } from '../../utility/technology.service';
import { saveAs } from 'file-saver';
import { saveAs as importedSaveAs } from "file-saver";

@Component({
  selector: 'app-material-view',
  templateUrl: './material-view.component.html',
  styleUrls: ['./material-view.component.scss']
})
export class MaterialViewComponent implements OnInit {

  selected: number
  technologyId: number
  material: any
  constructor(
    private _activeRoute: ActivatedRoute,
    private _techServ: TechnologyService,
    private _toaster: ToastrService
  ) {
    _activeRoute.params.subscribe(data => {
      this.technologyId = data.id
    })
  }

  ngOnInit(): void {
    this.viewMaterial();

  }

  viewMaterial() {
    this._techServ.viewAllTutorMaterial(this.technologyId).subscribe(data => {
      if (data != null)
        this.material = data;
      else
        this._toaster.error("Something went wrong")
    })
  }

  downloadMaterial(materialId: number, i: number) {
    this._techServ.downloadMaterial(materialId).subscribe(data => {
      if (data != null) {
        importedSaveAs(data, this.material[i].fileName + '.' + this.material[i].fileType);
        this._toaster.success("File successfully Downloaded")
      }
      else
        this._toaster.error("File not found");
    })
  }

  deleteMaterial(materialId: number) {
    this._techServ.deleteMaterial(materialId).subscribe(data => {
      if (data != null) 
        this._toaster.success("Material Deleted successfully")
        else
        this._toaster.error("File not found");
    })
}

}
