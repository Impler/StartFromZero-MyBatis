package com.study.mybatis.domain;

import java.util.List;

/**
 * 地域
 * 
 * @author impler
 * @date 2017-02-24
 */
public class Region {

	private int id;
	private String name;
	// 级别
	private int level;
	// 子地域
	private List<Region> childRegions;
	// 关联图
	private List<Image> images;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Region> getChildRegions() {
		return childRegions;
	}

	public void setChildRegions(List<Region> childRegions) {
		this.childRegions = childRegions;
	}

	public List<Image> getImages() {
		return images;
	}

	public void setImages(List<Image> images) {
		this.images = images;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((childRegions == null) ? 0 : childRegions.hashCode());
		result = prime * result + id;
		result = prime * result + ((images == null) ? 0 : images.hashCode());
		result = prime * result + level;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Region other = (Region) obj;
		if (childRegions == null) {
			if (other.childRegions != null)
				return false;
		} else if (!childRegions.equals(other.childRegions))
			return false;
		if (id != other.id)
			return false;
		if (images == null) {
			if (other.images != null)
				return false;
		} else if (!images.equals(other.images))
			return false;
		if (level != other.level)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Region [id=" + id + ", name=" + name + ", level=" + level
				+ ", childRegions=" + childRegions + ", images=" + images + "]";
	}

	
}
