export class Doctor{

    roleId :number;
	roleName:string;

	// cm_appoinmentTable
	
	appId:number;
	regId:number;
	dId:number;
	dateOfApp:Date;
	consultStatus:string;

	// cm_doctorTable
	//     dId;
	dSpec:string;
    dQualification:string;
    consultFee:number;

	// cm_patientTable
	//     regId;
	pFName:string;
	pLName:string;
    pGender:string;
    pDOB:Date;
	pAddr:string;
	pPhNo:string;
    pBloodGrp:string;
	pcreatedDate:Date;

	// cm_prescriptionTable
	prescId:number;
	medFreq:string;
	medDays:number;
	prescDate:Date;
	pharmacyStatus:string;

	// cm_doctorObsTable
	dObsId:number;
	obserDate:Date;
	obsNotes:string;

	// cm_assignLabTable
    assignLabId:number;
	assigLabDate:Date;
	sampleStatus:string;
	testStatus:string;

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
	isSActive:number;
	sCreatedDate:Date;

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

}