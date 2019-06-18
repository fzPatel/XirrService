package com.MlMaster.DaoImp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import org.springframework.stereotype.Component;
import com.MlMaster.Bean.CasteData;
import com.MlMaster.Bean.CasteDataAr;
import com.MlMaster.Bean.GenderData;
import com.MlMaster.Bean.GenderDataAr;
import com.MlMaster.Bean.HrmsvotrationData;
import com.MlMaster.Bean.HrmsvotrationDataAr;
import com.MlMaster.Bean.LdGrid;
import com.MlMaster.Bean.LdGridAr;
import com.MlMaster.Bean.LoanData;
import com.MlMaster.Bean.LoanDataAr;
import com.MlMaster.Bean.MaritalData;
import com.MlMaster.Bean.MaritalDataAr;
import com.MlMaster.Bean.McmodeData;
import com.MlMaster.Bean.McmodeDataAr;
import com.MlMaster.Bean.MotherTongueData;
import com.MlMaster.Bean.MotherTongueDataAr;
import com.MlMaster.Bean.ReligionData;
import com.MlMaster.Bean.ReligionDataAr;
import com.MlMaster.Bean.StateKycData;
import com.MlMaster.Bean.StateKycDataAr;
import com.MlMaster.Bean.TradeData;
import com.MlMaster.Bean.TradeDataAr;
import com.MlMaster.Dao.MlMasterDao;
import com.Rest.DataBase.DBConn;
import com.ltfs.log.PerfiosLogger;

@Component
public class MlMasterDaoImpl implements MlMasterDao {
	DBConn dbConn = new DBConn();
	PreparedStatement prepareStatement;

	public GenderDataAr getGenderData() {
		ArrayList<GenderData> genderData = new ArrayList<GenderData>();
		GenderDataAr genderDataAr = new GenderDataAr();
		try {
			System.out.println(" inside GendderDataDaoImpl");
			String query = "select * from TBL_Gender";

			Connection con = dbConn.getDBConnectionForPro();
			prepareStatement = con.prepareStatement(query);
			// prepareStatement.setString(1, );
			ResultSet result = prepareStatement.executeQuery();
			while (result.next()) {
				GenderData genderDataObj = new GenderData();

				genderDataObj.setId(result.getString("ID"));
				genderDataObj.setGender(result.getString("Gender"));
				genderData.add(genderDataObj);
			}

			genderDataAr.setGenderData(genderData);

		} catch (SQLException e) {

			PerfiosLogger.error(e.getMessage(), e);
		}

		return genderDataAr;

	}

	public LdGridAr loanDetailGrid() {

		ArrayList<LdGrid> ldGrid = new ArrayList<LdGrid>();
		LdGridAr ldGridAr = new LdGridAr();
		try {
			String query = "select * from Loan_Detail_Grid";

			Connection con = dbConn.getDBConnectionForPro();
			prepareStatement = con.prepareStatement(query);
			// prepareStatement.setString(1, );
			ResultSet result = prepareStatement.executeQuery();
			while (result.next()) {
				LdGrid ldGridObj = new LdGrid();
				ldGridObj.setDisb_amt(result.getString("Disb_Amt"));
				ldGridObj.setProc_fee(result.getString("Proc_fee"));
				ldGridObj.setCli(result.getString("CLI"));
				ldGridObj.setLoan_amt(result.getString("Loan_Amt"));
				ldGridObj.setEmi(result.getString("EMI"));
				ldGrid.add(ldGridObj);
			}
			ldGridAr.setLdGrid(ldGrid);
		} catch (SQLException e) {
			PerfiosLogger.error(e.getMessage(), e);
		}
		return ldGridAr;
	}

	public MaritalDataAr getMaritalData() {
		ArrayList<MaritalData> maritalData = new ArrayList<MaritalData>();
		MaritalDataAr maritalDataAr = new MaritalDataAr();
		try {
			String query = "select * from TBL_Marital_Status";

			Connection con = dbConn.getDBConnectionForPro();
			prepareStatement = con.prepareStatement(query);
			// prepareStatement.setString(1, );
			ResultSet result = prepareStatement.executeQuery();
			while (result.next()) {
				MaritalData maritalDataObj = new MaritalData();
				maritalDataObj.setId(result.getString("ID"));
				maritalDataObj.setMaritalstatus(result.getString("Marital_Status"));
				maritalData.add(maritalDataObj);
			}
			maritalDataAr.setMaritalDataAr(maritalData);

		} catch (SQLException e) {
			PerfiosLogger.error(e.getMessage(), e);
		}

		return maritalDataAr;

	}

	public ReligionDataAr religionData() {
		ArrayList<ReligionData> religionData = new ArrayList<ReligionData>();
		ReligionDataAr religionDataAr = new ReligionDataAr();
		try {
			String query = "select * from TBL_RELIGION_MSTR";
			Connection con = dbConn.getDBConnectionForPro();
			prepareStatement = con.prepareStatement(query);
			// prepareStatement.setString(1, );
			ResultSet result = prepareStatement.executeQuery();
			while (result.next()) {
				ReligionData religionDataObj = new ReligionData();
				religionDataObj.setId(result.getString("ID"));
				religionDataObj.setDisplayorder(result.getString("SubCodeID"));
				religionDataObj.setDescription(result.getString("Description"));
				religionDataObj.setSubcodeid(result.getString("DisplayOrder"));
				religionData.add(religionDataObj);
			}
			religionDataAr.setReligionData(religionData);

		} catch (SQLException e) {
			PerfiosLogger.error(e.getMessage(), e);
		}

		return religionDataAr;

	}

	public StateKycDataAr stateKycData() {
		ArrayList<StateKycData> stateKycData = new ArrayList<StateKycData>();
		StateKycDataAr stateKycDataAr = new StateKycDataAr();
		try {
			String query = "select * from TBL_State_EKYC";

			Connection con = dbConn.getDBConnectionForPro();
			prepareStatement = con.prepareStatement(query);
			// prepareStatement.setString(1, );
			ResultSet result = prepareStatement.executeQuery();
			while (result.next()) {
				StateKycData stateKycDataObj = new StateKycData();
				stateKycDataObj.setId(result.getString("ID"));
				stateKycDataObj.setMc_id(result.getString("MC_ID"));
				stateKycDataObj.setState_id(result.getString("State_ID"));
				stateKycData.add(stateKycDataObj);
			}
			stateKycDataAr.setStateKycData(stateKycData);

		} catch (SQLException e) {
			PerfiosLogger.error(e.getMessage(), e);
		}

		return stateKycDataAr;

	}

	public TradeDataAr tradeData() {
		ArrayList<TradeData> tradeData = new ArrayList<TradeData>();
		TradeDataAr tradeDataAr = new TradeDataAr();
		try {
			String query = "select * from TBL_TRADE_MSTR";
			Connection con = dbConn.getDBConnectionForPro();
			prepareStatement = con.prepareStatement(query);
			// prepareStatement.setString(1, );
			ResultSet result = prepareStatement.executeQuery();
			while (result.next()) {
				TradeData tradeDataObj = new TradeData();
				tradeDataObj.setId(result.getString("ID"));
				tradeDataObj.setTradename(result.getString("Trade_Name"));
				tradeData.add(tradeDataObj);
			}
			tradeDataAr.setTradeData(tradeData);

		} catch (SQLException e) {
			PerfiosLogger.error(e.getMessage(), e);
		}
		return tradeDataAr;

	}

	public MotherTongueDataAr motherTongueDataAr() {
		ArrayList<MotherTongueData> motherTongueData = new ArrayList<MotherTongueData>();
		MotherTongueDataAr motherTongueDataAr = new MotherTongueDataAr();
		try {
			String query = "select * from TBL_MOTHERTONGUE_MSTR";
			Connection con = dbConn.getDBConnectionForPro();
			prepareStatement = con.prepareStatement(query);
			// prepareStatement.setString(1, );
			ResultSet result = prepareStatement.executeQuery();
			while (result.next()) {
				MotherTongueData motherTongueDataObj = new MotherTongueData();
				motherTongueDataObj.setId(result.getString("id"));
				motherTongueDataObj.setSubCodeId(result.getString("SubCodeId"));
				motherTongueDataObj.setDisplayorder(result.getString("Description"));
				motherTongueDataObj.setDescription(result.getString("DissplayOrder"));
				motherTongueData.add(motherTongueDataObj);
			}
			motherTongueDataAr.setMotherTongueData(motherTongueData);

		} catch (SQLException e) {
			PerfiosLogger.error(e.getMessage(), e);
		}

		return motherTongueDataAr;
	}

	public LoanDataAr loanDataAr() {
		ArrayList<LoanData> loanData = new ArrayList<LoanData>();
		LoanDataAr loanDataAr = new LoanDataAr();
		try {
			String query = "select * from TBL_LoanMaster";

			Connection con = dbConn.getDBConnectionForPro();
			prepareStatement = con.prepareStatement(query);
			// prepareStatement.setString(1, );
			ResultSet result = prepareStatement.executeQuery();
			while (result.next()) {
				LoanData loanDataObj = new LoanData();
				loanDataObj.setId(result.getString("ID"));
				loanDataObj.setInterestrate(result.getString("Type of loan"));
				loanDataObj.setLoantype(result.getString("Interest rate"));
				loanDataObj.setTenuremonths(result.getString("Tenure (In months)"));
				loanData.add(loanDataObj);
			}
			loanDataAr.setLoanData(loanData);

		} catch (SQLException e) {
			PerfiosLogger.error(e.getMessage(), e);
		}

		return loanDataAr;
	}

	public CasteDataAr casteData() {
		ArrayList<CasteData> casteData = new ArrayList<CasteData>();
		CasteDataAr casteDataAr = new CasteDataAr();
		try {
			String query = "select * from TBL_CASTE_MSTR";

			Connection con = dbConn.getDBConnectionForPro();
			prepareStatement = con.prepareStatement(query);
			// prepareStatement.setString(1, );
			ResultSet result = prepareStatement.executeQuery();
			while (result.next()) {
				CasteData casteDataobj = new CasteData();
				casteDataobj.setId(result.getString("ID"));
				casteDataobj.setSubCodeId(result.getString("SubCodeID"));
				casteDataobj.setDisplayorder(result.getString("DisplayOrder"));
				casteDataobj.setDescription(result.getString("Description"));
				casteData.add(casteDataobj);
			}
			casteDataAr.setCasteData(casteData);

		} catch (SQLException e) {
			PerfiosLogger.error(e.getMessage(), e);
		}

		return casteDataAr;
	}

	public HrmsvotrationDataAr hrmsvotrationData() {
		ArrayList<HrmsvotrationData> hrmsvotrationData = new ArrayList<HrmsvotrationData>();
		HrmsvotrationDataAr hrmsvotrationDataAr = new HrmsvotrationDataAr();
		try {
			String query = "select * from TBL_HRMS_VOTER_RATION_DETAILS";
			//

			Connection con = dbConn.getDBConnectionForPro();
			prepareStatement = con.prepareStatement(query);
			// prepareStatement.setString(1, );
			ResultSet result = prepareStatement.executeQuery();
			while (result.next()) {
				HrmsvotrationData hrmsvotrationDataObj = new HrmsvotrationData();
				hrmsvotrationDataObj.setMccode(result.getString("MCCODE"));
				hrmsvotrationDataObj.setRation_card(result.getString("Ration_Card"));
				hrmsvotrationDataObj.setVoter_card(result.getString("Voter_Card"));
				hrmsvotrationData.add(hrmsvotrationDataObj);
			}
			hrmsvotrationDataAr.setHrmsvotrationData(hrmsvotrationData);

		} catch (SQLException e) {
			PerfiosLogger.error(e.getMessage(), e);
		}

		return hrmsvotrationDataAr;
	}

	public McmodeDataAr mcmodeData() {
		ArrayList<McmodeData> mcmodeData = new ArrayList<McmodeData>();
		McmodeDataAr mcmodeDataAr = new McmodeDataAr();
		try {
			String query = "select * from TBL_HRMS_MCMode";
			Connection con = dbConn.getDBConnectionForPro();
			prepareStatement = con.prepareStatement(query);
			// prepareStatement.setString(1, );
			ResultSet result = prepareStatement.executeQuery();
			while (result.next()) {
				McmodeData mcmodeDataObj = new McmodeData();
				mcmodeDataObj.setMccode(result.getString("MCCODE"));
				mcmodeDataObj.setMode(result.getString("MODE"));

				mcmodeData.add(mcmodeDataObj);
			}
			mcmodeDataAr.setMcmodeData(mcmodeData);

		} catch (SQLException e) {
			PerfiosLogger.error(e.getMessage(), e);
		}

		return mcmodeDataAr;
	}

	public ArrayList<GenderData> takeData() {
		ArrayList<GenderData> mtd = new ArrayList<GenderData>();

		GenderDataAr mtda = new GenderDataAr();

		GenderData data1 = new GenderData();
		data1.setId("Firoz101");
		data1.setGender("Male");

		GenderData data2 = new GenderData();
		data2.setId("Aman102");
		data2.setGender("Female");

		mtd.add(data1);
		mtd.add(data2);

		return mtd;
	}

}