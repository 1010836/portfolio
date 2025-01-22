/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package entity.resource.entity.mopp;

public class EntityTokenStyleInformationProvider {
	
	public static String TASK_ITEM_TOKEN_NAME = "TASK_ITEM";
	
	public entity.resource.entity.IEntityTokenStyle getDefaultTokenStyle(String tokenName) {
		if ("Model".equals(tokenName)) {
			return new entity.resource.entity.mopp.EntityTokenStyle(new int[] {0x7F, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("Title".equals(tokenName)) {
			return new entity.resource.entity.mopp.EntityTokenStyle(new int[] {0x7F, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("rootEntities".equals(tokenName)) {
			return new entity.resource.entity.mopp.EntityTokenStyle(new int[] {0x7F, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("Entity".equals(tokenName)) {
			return new entity.resource.entity.mopp.EntityTokenStyle(new int[] {0x7F, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("Name".equals(tokenName)) {
			return new entity.resource.entity.mopp.EntityTokenStyle(new int[] {0x7F, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("attributes".equals(tokenName)) {
			return new entity.resource.entity.mopp.EntityTokenStyle(new int[] {0x7F, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("relations".equals(tokenName)) {
			return new entity.resource.entity.mopp.EntityTokenStyle(new int[] {0x7F, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("Attribute".equals(tokenName)) {
			return new entity.resource.entity.mopp.EntityTokenStyle(new int[] {0x7F, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("Type".equals(tokenName)) {
			return new entity.resource.entity.mopp.EntityTokenStyle(new int[] {0x7F, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("Relation".equals(tokenName)) {
			return new entity.resource.entity.mopp.EntityTokenStyle(new int[] {0x7F, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("RelEntity".equals(tokenName)) {
			return new entity.resource.entity.mopp.EntityTokenStyle(new int[] {0x7F, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("has entities".equals(tokenName)) {
			return new entity.resource.entity.mopp.EntityTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("String".equals(tokenName)) {
			return new entity.resource.entity.mopp.EntityTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("Float".equals(tokenName)) {
			return new entity.resource.entity.mopp.EntityTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("Integer".equals(tokenName)) {
			return new entity.resource.entity.mopp.EntityTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("Boolean".equals(tokenName)) {
			return new entity.resource.entity.mopp.EntityTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("one".equals(tokenName)) {
			return new entity.resource.entity.mopp.EntityTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("many".equals(tokenName)) {
			return new entity.resource.entity.mopp.EntityTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("QUOTED_34_34".equals(tokenName)) {
			return new entity.resource.entity.mopp.EntityTokenStyle(new int[] {0x2A, 0x00, 0xFF}, null, false, false, false, false);
		}
		if ("TASK_ITEM".equals(tokenName)) {
			return new entity.resource.entity.mopp.EntityTokenStyle(new int[] {0x7F, 0x9F, 0xBF}, null, true, false, false, false);
		}
		return null;
	}
	
}
