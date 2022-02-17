export interface ITutor {
    technologyname:string
    rating:number
    belongsToTutor:{
        id:number
        username:string
        email:string
        specialization:string
        experience:number
    }
}
