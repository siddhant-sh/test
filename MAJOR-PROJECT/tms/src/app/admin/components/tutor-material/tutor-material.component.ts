import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { TutorService } from '../../utility/tutor.service';
import { saveAs as importedSaveAs } from "file-saver";
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-tutor-material',
  templateUrl: './tutor-material.component.html',
  styleUrls: ['./tutor-material.component.scss']
})
export class TutorMaterialComponent implements OnInit {

  technologyId:number;
  materialList:any;
  constructor(private _activeRoute: ActivatedRoute , private _tutorSer : TutorService,  private _toaster: ToastrService) { 
    this._activeRoute.params.subscribe(data=>{
      this.technologyId=data.id;
    })
  }

  ngOnInit(): void {
    this.getMaterial();
  }

getMaterial(){
  this._tutorSer.viewAllTutorMaterial(this.technologyId).subscribe(data=>{
    if(data!=null){
      this.materialList=data;
      console.log(this.materialList);
      
    }
  })
}

downloadMaterial(materialId: number, i: number) {
  this._tutorSer.downloadMaterial(materialId).subscribe(data => {
    if (data != null) {
      importedSaveAs(data, this.materialList[i].fileName + '.' + this.materialList[i].fileType);
      this._toaster.success("File successfully Downloaded")
    }
    else
      this._toaster.error("File not found");
  })
}
}
