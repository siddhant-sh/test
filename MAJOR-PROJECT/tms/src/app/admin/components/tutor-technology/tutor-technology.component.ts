import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { TutorService } from '../../utility/tutor.service';

@Component({
  selector: 'app-tutor-technology',
  templateUrl: './tutor-technology.component.html',
  styleUrls: ['./tutor-technology.component.scss']
})
export class TutorTechnologyComponent implements OnInit {

  tutorId: number;
  technologies: any;
  constructor(
    private _activeRoute: ActivatedRoute,
    private _tutorSer: TutorService,
    private _toaster: ToastrService,
    private _router: Router
  ) {
    this._activeRoute.params.subscribe(data => {
      this.tutorId = data.id;
    })
  }

  ngOnInit(): void {
    this.getMaterial();
  }

  getMaterial() {
    this._tutorSer.getTechnologyList(this.tutorId).subscribe(data => {
      if (data != null) {
        this.technologies = data;
        console.log(this.technologies);
        
      }
    })
  }

  viewMaterial(id: number) {

    this._router.navigate(['/adminhome/admin/tutor-material/' + id])
  }
}
