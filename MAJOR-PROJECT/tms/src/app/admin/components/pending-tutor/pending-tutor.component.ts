import { Component, OnInit } from '@angular/core';
import { TutorService } from '../../utility/tutor.service';

@Component({
  selector: 'app-pending-tutor',
  templateUrl: './pending-tutor.component.html',
  styleUrls: ['./pending-tutor.component.scss']
})
export class PendingTutorComponent implements OnInit {
  tutorList: any;
  msg:any
  errorMessage: any;
  constructor(private _tutorser:TutorService) { }

  ngOnInit(): void {
    this.getApprovedTutorlist();
  }

  getApprovedTutorlist(){
    this._tutorser.getAllTutorForApproval().subscribe(data=>{
    this.tutorList=data;
    })
    }

    approved(id:any){  
      this._tutorser.approvedTutorById(id).subscribe({
        next: data => {
          this.msg = data
          this.ngOnInit();
      },
      
        error: error => {
          this.errorMessage = error.message;
          console.error('There was an error!', error);
      }
      })
      }
      
      block(id:any){  
        this._tutorser.blockTutorById(id).subscribe({
          next: data => {
            this.msg = data
            this.ngOnInit();
        },
        
          error: error => {
            this.errorMessage = error.message;
            console.error('There was an error!', error);
        }
        })
        }
      
        reject(id:any){  
          this._tutorser.rejectTutorById(id).subscribe({
            next: data => {
              this.msg = data
              this.ngOnInit();
          },
          
            error: error => {
              this.errorMessage = error.message;
              console.error('There was an error!', error);
          }
          })
          }
      
      }
      