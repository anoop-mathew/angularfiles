export class Admin{

/* cm_roleTable */
    roleId:number;
    roleName:string;

// cm_staffTable
    sId:number;
    sName:string;
    sDOB:Date;
    sGender:string;
    sAddr:string;
    sExp:string;
    sPhNo:string;
    sEmail:string;
    username:string;
    password:string;
    isSActive:string;
    sCreated:Date;

    
// cm_doctorTable
    dId:number;
    dSpec:string;
    dQualification:string;
    consultFee:number;

// cm_medicineTable
    medId:number;
    medName:string;
    medPrice:number;
    isMActive:number;
    manufacturer:string;
    mCreatedDate:Date;

// cm_labTestTable
    labId:number;
    lName:string;
    lFee:number;
    description:string;

// cm_consultDayTable 
// cm_consultDayTable 
consultDayId:number;	
sunday:string;
monday:string;
tuesday:string;
wednesday:string;
thursday:string;
friday:string;
saturday:string; 
}