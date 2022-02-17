import { Component, OnInit } from '@angular/core';
import { ChartDataSets, ChartOptions, ChartType } from 'chart.js';
import { Color, Label } from 'ng2-charts';
import { TutorService } from '../../utility/tutor.service';


@Component({
  selector: 'app-reports',
  templateUrl: './reports.component.html',
  styleUrls: ['./reports.component.scss']
})
export class ReportsComponent implements OnInit {

  tutorList=[]
  tutNames=[]
  studCount=[]
  techtutor=[]
  mateTutor=[]
  downloadList=[]
  techCount=[]
  materialCount=[]
  DownloadCount=[]

  public barChartOptions: ChartOptions = {
    responsive: true,
    // We use these empty structures as placeholders for dynamic theming.
    scales: { xAxes: [{}], yAxes: [{ticks:{beginAtZero:true}}] },
    plugins: {
      datalabels: {
        anchor: 'end',
        align: 'end',
      }
    }
  };
  public barChartLabels: Label[] = this.tutNames;
  public barChartType: ChartType = 'bar';
  public barChartLegend = true;
  public barChartPlugins = [];

  public barChartData: ChartDataSets[] = 
  [
    {data:this.studCount,label:'Student Count'},
    {data:this.techCount,label:'Technology Count'},
    {data:this.materialCount,label:'Material Count'},
    {data:this.DownloadCount,label:'Download Count'},
  ];
  constructor(
    private _tutorser: TutorService
  ) { }

  ngOnInit(): void {
    this.getApprovedTutorlist();
  }

  // events
  public chartClicked({ event, active }: { event: MouseEvent, active: {}[] }): void {
  }

  public chartHovered({ event, active }: { event: MouseEvent, active: {}[] }): void {
  }

  getApprovedTutorlist() {
    this._tutorser.getAllApprovedTutor().subscribe(data => {
      if(data!=null){
        // data.sort((a, b) => (a.studCount > b.studCount ? -1 : 1));
        this.tutorList=data;
        this.getTechCountForTutor()
      }  
    })
  }

  getTechCountForTutor(){
    this._tutorser.getTechnologyCount().subscribe(data=>{
      this.techtutor=data
      this.getMaterialForTutor();
    })
  }
  getMaterialForTutor(){
    this._tutorser.getMaterialCount().subscribe(data=>{
      this.mateTutor=data
      this.getMaterialDownloadForTutor()
    })
  }
  getMaterialDownloadForTutor(){
    this._tutorser.getMaterialDownloadCount().subscribe(data=>{
      this.downloadList=data
      this.processData()
    })
  }
  processData(){
    this.tutorList.sort((a, b) => (a.studCount > b.studCount ? -1 : 1));
    this.tutorList.forEach(tutor=>{
      this.tutNames.push(tutor.username)
      this.studCount.push(tutor.studCount)
      this.techtutor.forEach(tech=>{
        if(tech.tutorId==tutor.id)
        this.techCount.push(tech.count)
      })
      this.mateTutor.forEach(mat=>{
        if(mat.tutorId==tutor.id)
        this.materialCount.push(mat.count)
      })
      this.downloadList.forEach(download=>{
        this.DownloadCount.push(download.count)
      })
    })
  }
}
