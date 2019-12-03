export class FrontOffice{

        roleId:number;
	    roleName:string;

	// Staff table
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
	    screatedDate:Date;

	// Doctor table
	    dId:number;
	    dSpec:string;
	    dQualification:string;
	    consultFee:number;

	// Patient Table
	    regId:number;
	    pFName:string;
	    pLName:string;
	    pGender:string;
	    pDOB:Date;
	    pAddr:string;
	    pPhNo:string;
	    pBloodGrp:string;
	    pcreatedDate:string;

	// Appo ment table
	    appId:number;
	    dateOfApp:Date;
	    consultStatus:string;

	// FrontOffice Billing table
	    fBillId:number;
	    billDate:Date;
	    admFee:number;
		age:number;
	
	// cm_consultDayTable 
	consultDayId:number;	
	sunday:string;
	monday:string;
	tueday:string;
	wednesday:string;
	thursday:string;
	friday:string;
	saturday:string; 

	
}