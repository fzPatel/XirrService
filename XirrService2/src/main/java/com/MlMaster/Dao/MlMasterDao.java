package com.MlMaster.Dao;


import com.MlMaster.Bean.CasteDataAr;
import com.MlMaster.Bean.GenderDataAr;
import com.MlMaster.Bean.HrmsvotrationDataAr;
import com.MlMaster.Bean.LdGridAr;
import com.MlMaster.Bean.LoanDataAr;
import com.MlMaster.Bean.MaritalDataAr;
import com.MlMaster.Bean.McmodeDataAr;
import com.MlMaster.Bean.MotherTongueDataAr;
import com.MlMaster.Bean.ReligionDataAr;
import com.MlMaster.Bean.StateKycDataAr;
import com.MlMaster.Bean.TradeDataAr;

public interface MlMasterDao {

	public GenderDataAr getGenderData() throws Exception;
	public LdGridAr loanDetailGrid()throws Exception;
	public MaritalDataAr getMaritalData()throws Exception;
	public ReligionDataAr religionData()throws Exception;
	public StateKycDataAr stateKycData()throws Exception;
	public TradeDataAr tradeData()throws Exception;
	public MotherTongueDataAr motherTongueDataAr()throws Exception;
	public LoanDataAr loanDataAr()throws Exception;
	public CasteDataAr casteData()throws Exception;
	public HrmsvotrationDataAr hrmsvotrationData()throws Exception;
	public McmodeDataAr mcmodeData()throws Exception;

}
