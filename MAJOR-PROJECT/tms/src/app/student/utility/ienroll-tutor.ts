export interface IEnrollTutor {
    tutor: {
        technologyname: string
        rating: number
        belongsToTutor: {
            username: string
            email: string
            specialization: string
            experience: number
        }
    }
    feedback: number
    
}
