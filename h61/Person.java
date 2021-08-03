package com.huawei.classroom.student.h61;

//新建类Person来模拟市民
/*包含的属性有：
 * id:编号
 * Family:所属家庭
 * Company:所属公司
 * State:当前状况
 * latentDays:潜伏期时间
 * immued:是否已经免疫
 */
public class Person {
	private int id;
	private Family family;
	private Company company;
	private Enum_States state;
	private int latentDays = -1;
	private boolean immued=false;

	public boolean isImmued() {
		return immued;
	}

	public void setImmued(boolean immued) {
		this.immued = immued;
	}

	public Person(int id) {
		this.id=id;
		state=Enum_States.health;
		latentDays = -1;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Family getFamily() {
		return family;
	}

	public void setFamily(Family family) {
		this.family = family;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public Enum_States getState() {
		return state;
	}

	public void setState(Enum_States state) {
		this.state = state;
	}

	public int getLatentDays() {
		return latentDays;
	}

	public void setLatentDays(int latentDays) {
		this.latentDays = latentDays;
	}

	public void infected() {
		this.state = Enum_States.latent;
		this.latentDays = 0;
	}

	public void passOneDay(Simulate simulate) {
		if (this.getState() == Enum_States.ill_home) {
			if (myUtil.getPossibility(simulate.getParam().getDeathRateHome())) {
				this.state = Enum_States.dead;
			}
			if (myUtil.getPossibility(simulate.getParam().getHealingRateHome())) {
				this.state = Enum_States.cured;
			}
		}
		if (this.getState() == Enum_States.ill_hospital) {
			if (myUtil.getPossibility(simulate.getParam().getDeathRateHospital())) {
				this.state = Enum_States.dead;
			}
			if (myUtil.getPossibility(simulate.getParam().getHealingRateHospital())) {
				this.state = Enum_States.cured; 
			}
		}
		if (this.state == Enum_States.latent) {
			latentDays++;
		}

		if (this.state == Enum_States.health) {
			double effect=0;
			if(this.isImmued()) {
				effect=simulate.getParam().getImmuEffect();
			}
			if (this.family.nfectionExist()) {
				checkInfected(simulate.getParam().getSpreadRateFamily()*(1-effect) );
			}
			if (this.company.nfectionExist()) {
				checkInfected(simulate.getParam().getSpreadRateCompany()*(1-effect));
			}
			
		}

		if (this.state == Enum_States.latent) {
			if (this.latentDays > simulate.getParam().getLatentPeriod()) {
				this.state = Enum_States.ill_home;
				simulate.getHospital().appendPatients(this);
			}
			
		}

	}

	public void checkInfected(double spreadRate) {
		if (this.getState() == Enum_States.health) {
			if (myUtil.getPossibility(spreadRate)) {
				this.infected();
			}
		}
	}

	//重写hashCode函数
	//将id作为每个Person对象的哈希编码
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return this.id;
	}

	//重写equals函数
	//如果obj是Person类的一个对象且当this.id与obj.id相等时返回true
	//否则返回false
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if (obj instanceof Person) {
			return this.id == ((Person) obj).id;
		} else {
			return false;
		}
	}

}
