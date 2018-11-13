package org.fkit.fm.dao;

import static org.fkit.fm.util.commom.FmConstants.PROPERTYTABLE;

import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.UpdateProvider;
import org.fkit.fm.dao.provider.PropertyDynaSqlProvider;
import org.fkit.fm.domain.MyProperty;

public interface PropertyDao {
	// ÃÌº”…Ë÷√ Ù–‘
	@InsertProvider(type = PropertyDynaSqlProvider.class, method = "insertProperty")
	void addProperty(MyProperty property);

	@Select("select * from " + PROPERTYTABLE)
	MyProperty findProperty();

	@UpdateProvider(type = PropertyDynaSqlProvider.class, method = "updateProperty")
	void updateProperty(MyProperty proeprty);

	

}
