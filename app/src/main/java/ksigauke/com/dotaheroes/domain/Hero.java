package ksigauke.com.dotaheroes.domain;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Hero {

    private int id;
    private String name;

    @SerializedName("localized_name")
    private String localizedName;

    @SerializedName("primary_attr")
    private String primaryAttribute;

    @SerializedName("attack_type")
    private String attackType;

    private List<String> roles;

    @SerializedName("img")
    private String imageUrl;

    @SerializedName("base_attack_min")
    private int attackMin;

    @SerializedName("base_attack_max")
    private int attackMax;

    @SerializedName("base_str")
    private int strength;


    @SerializedName("base_agi")
    private int agility;

    @SerializedName("base_int")
    private int intelligence;

    private Hero() {
    }

    public String getName() {
        return name;
    }

    public String getLocalizedName() {
        return localizedName;
    }

    public String getPrimaryAttribute() {
        return primaryAttribute;
    }

    public String getImageUrl() {
        return imageUrl;
    }


    private Hero(Builder builder) {
        id = builder.id;
        name = builder.name;
        localizedName = builder.localizedName;
        primaryAttribute = builder.primaryAttribute;
        attackType = builder.attackType;
        roles = builder.roles;
        imageUrl = builder.imageUrl;
        attackMin = builder.attackMin;
        attackMax = builder.attackMax;
        strength = builder.strength;
        agility = builder.agility;
        intelligence = builder.intelligence;
    }


    public final static class Builder {
        private int id;
        private String name;
        private String localizedName;
        private String primaryAttribute;
        private String attackType;
        private List<String> roles;
        private String imageUrl;
        private int attackMin;
        private int attackMax;
        private int strength;
        private int agility;
        private int intelligence;

        public Builder id(int id) {
            this.id = id;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder localizedName(String localizedName) {
            this.localizedName = localizedName;
            return this;
        }

        public Builder primaryAttribute(String primaryAttribute) {
            this.primaryAttribute = primaryAttribute;
            return this;
        }

        public Builder attackType(String attackType) {
            this.attackType = attackType;
            return this;
        }

        public Builder roles(List<String> roles) {
            this.roles = roles;
            return this;
        }

        public Builder imageUrl(String imageUrl) {
            this.imageUrl = imageUrl;
            return this;
        }

        public Builder attackMin(int attackMin) {
            this.attackMin = attackMin;
            return this;
        }

        public Builder attackMax(int attackMax) {
            this.attackMax = attackMax;
            return this;
        }

        public Builder strength(int strength) {
            this.strength = strength;
            return this;
        }

        public Builder agility(int agility) {
            this.agility = agility;
            return this;
        }

        public Builder intelligence(int intelligence) {
            this.intelligence = intelligence;
            return this;
        }

        public Hero build() {
            return new Hero(this);
        }
    }
}
