package com.example.demohilt.data


import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import android.os.Parcelable

@Parcelize
data class UserModel(
    @SerializedName("code")
    var code: String,
    @SerializedName("data")
    var userData: UserData?,
    @SerializedName("message")
    var message: String?,
) : Parcelable {
    @Parcelize
    data class UserData(
        @SerializedName("access_token")
        var accessToken: String,
        @SerializedName("account_status")
        var accountStatus: String,
        @SerializedName("account_status_at")
        var accountStatusAt: String,
        @SerializedName("account_status_by")
        var accountStatusBy: String,
        @SerializedName("address_lat")
        var addressLat: String,
        @SerializedName("address_line_1")
        var addressLine1: String,
        @SerializedName("address_line_2")
        var addressLine2: String,
        @SerializedName("address_long")
        var addressLong: String,
        @SerializedName("aws_profile_url")
        var awsProfileUrl: String,
        @SerializedName("business_type_id")
        var businessTypeId: String,
        @SerializedName("city_id")
        var cityId: String,
        @SerializedName("city_name")
        var cityName: String,
        @SerializedName("country_id")
        var countryId: String,
        @SerializedName("country_name")
        var countryName: String,
        @SerializedName("created_at")
        var createdAt: String,
        @SerializedName("created_by")
        var createdBy: String,
        @SerializedName("delete_flag")
        var deleteFlag: String,
        @SerializedName("deleted_at")
        var deletedAt: String,
        @SerializedName("deleted_by")
        var deletedBy: String,
        @SerializedName("email")
        var email: String,
        @SerializedName("email_verified_at")
        var emailVerifiedAt: String,
        @SerializedName("email_verified_code")
        var emailVerifiedCode: String,
        @SerializedName("expires_at")
        var expiresAt: String,
        @SerializedName("facility_detail")
        var facilityDetail: FacilityDetail,
        @SerializedName("facility_locations")
        var facilityLocations: List<FacilityLocation>,
        @SerializedName("first_name")
        var firstName: String,
        @SerializedName("hospital_detail_id")
        var hospitalDetailId: String,
        @SerializedName("hospital_id")
        var hospitalId: String,
        @SerializedName("id")
        var id: Int,
        @SerializedName("ip")
        var ip: String,
        @SerializedName("last_login")
        var lastLogin: String,
        @SerializedName("last_name")
        var lastName: String,
        @SerializedName("login_otp")
        var loginOtp: String,
        @SerializedName("login_otp_status")
        var loginOtpStatus: String,
        @SerializedName("middle_name")
        var middleName: String,
        @SerializedName("mobile")
        var mobile: String,
        @SerializedName("mobile_verified")
        var mobileVerified: String,
        @SerializedName("netspend_acc_no")
        var netspendAccNo: String,
        @SerializedName("netspend_acc_status")
        var netspendAccStatus: String,
        @SerializedName("netspend_enroll_datetime")
        var netspendEnrollDatetime: String,
        @SerializedName("notification_email")
        var notificationEmail: String,
        @SerializedName("notification_text")
        var notificationText: String,
        @SerializedName("object_id")
        var objectId: String,
        @SerializedName("organization_id")
        var organizationId: String,
        @SerializedName("payment_gateway")
        var paymentGateway: String,
        @SerializedName("profile")
        var profile: String,
        @SerializedName("profile_url")
        var profileUrl: String,
        @SerializedName("referral_by")
        var referralBy: String,
        @SerializedName("referral_code")
        var referralCode: String,
        @SerializedName("referral_type")
        var referralType: String,
        @SerializedName("region_id")
        var regionId: String,
        @SerializedName("region_name")
        var regionName: String,
        @SerializedName("role")
        var role: String,
        @SerializedName("state_id")
        var stateId: String,
        @SerializedName("state_name")
        var stateName: String,
        @SerializedName("suspend_reason")
        var suspendReason: String,
        @SerializedName("token_type")
        var tokenType: String,
        @SerializedName("updated_at")
        var updatedAt: String,
        @SerializedName("updated_by")
        var updatedBy: String,
        @SerializedName("verify_at")
        var verifyAt: String,
        @SerializedName("verify_otp")
        var verifyOtp: String,
        @SerializedName("verify_status")
        var verifyStatus: String,
        @SerializedName("welcome_flag")
        var welcomeFlag: String,
        @SerializedName("zipcode")
        var zipcode: String,
    ) : Parcelable {
        @Parcelize
        data class FacilityDetail(
            @SerializedName("abot_us_other")
            var abotUsOther: String,
            @SerializedName("about_us")
            var aboutUs: String,
            @SerializedName("address")
            var address: String,
            @SerializedName("address_line_2")
            var addressLine2: String,
            @SerializedName("agreement_check")
            var agreementCheck: String,
            @SerializedName("assign_to")
            var assignTo: String,
            @SerializedName("aws_compString_logo_url")
            var awsCompStringLogoUrl: String,
            @SerializedName("aws_login_banner_url")
            var awsLoginBannerUrl: String,
            @SerializedName("aws_register_banner_url")
            var awsRegisterBannerUrl: String,
            @SerializedName("city_name")
            var cityName: String,
            @SerializedName("compString_logo")
            var compStringLogo: String,
            @SerializedName("compString_logo_url")
            var compStringLogoUrl: String,
            @SerializedName("compString_photo")
            var compStringPhoto: String,
            @SerializedName("compString_photo_url")
            var compStringPhotoUrl: String,
            @SerializedName("compString_stage")
            var compStringStage: String,
            @SerializedName("contact_person_name")
            var contactPersonName: String,
            @SerializedName("created_at")
            var createdAt: String,
            @SerializedName("created_by")
            var createdBy: String,
            @SerializedName("credit_config_flag")
            var creditConfigFlag: String,
            @SerializedName("credit_time_limit")
            var creditTimeLimit: String,
            @SerializedName("delete_flag")
            var deleteFlag: String,
            @SerializedName("deleted_at")
            var deletedAt: String,
            @SerializedName("deleted_by")
            var deletedBy: String,
            @SerializedName("email")
            var email: String,
            @SerializedName("facility_confirmation")
            var facilityConfirmation: String,
            @SerializedName("facility_status")
            var facilityStatus: String,
            @SerializedName("facility_type")
            var facilityType: Int,
            @SerializedName("fax")
            var fax: String,
            @SerializedName("hospital_detailcol")
            var hospitalDetailcol: String,
            @SerializedName("hospital_user_fk")
            var hospitalUserFk: Int,
            @SerializedName("id")
            var id: Int,
            @SerializedName("instant_confirmation")
            var instantConfirmation: String,
            @SerializedName("invoice_type")
            var invoiceType: String,
            @SerializedName("lang")
            var lang: String,
            @SerializedName("lat")
            var lat: String,
            @SerializedName("late_call_off_change_shift_type_flag")
            var lateCallOffChangeShiftTypeFlag: String,
            @SerializedName("legal_compString_name")
            var legalCompStringName: String,
            @SerializedName("market_type_id")
            var marketTypeId: String,
            @SerializedName("pending_bid_limit")
            var pendingBidLimit: String,
            @SerializedName("phone")
            var phone: String,
            @SerializedName("rating")
            var rating: String,
            @SerializedName("shift_clock_in_manual_update")
            var shiftClockInManualUpdate: String,
            @SerializedName("shift_clock_out_manual_update")
            var shiftClockOutManualUpdate: String,
            @SerializedName("show_bill_rate")
            var showBillRate: String,
            @SerializedName("show_mandatory_lunch_break")
            var showMandatoryLunchBreak: String,
            @SerializedName("state_name")
            var stateName: String,
            @SerializedName("unpaid_break")
            var unpaidBreak: String,
            @SerializedName("unpaid_break_time")
            var unpaidBreakTime: String,
            @SerializedName("updated_at")
            var updatedAt: String,
            @SerializedName("updated_by")
            var updatedBy: String,
            @SerializedName("website_url")
            var websiteUrl: String,
            @SerializedName("zipcode")
            var zipcode: String,
        ) : Parcelable

        @Parcelize
        data class FacilityLocation(
            @SerializedName("account_id")
            var accountId: String,
            @SerializedName("additional_instruction")
            var additionalInstruction: String,
            @SerializedName("address")
            var address: String,
            @SerializedName("address2")
            var address2: String,
            @SerializedName("aws_image_url")
            var awsImageUrl: String,
            @SerializedName("city_name")
            var cityName: String,
            @SerializedName("contact_person_name")
            var contactPersonName: String,
            @SerializedName("created_at")
            var createdAt: String,
            @SerializedName("created_by")
            var createdBy: String,
            @SerializedName("delete_flag")
            var deleteFlag: String,
            @SerializedName("deleted_at")
            var deletedAt: String,
            @SerializedName("deleted_by")
            var deletedBy: String,
            @SerializedName("description")
            var description: String,
            @SerializedName("email")
            var email: String,
            @SerializedName("facility_type")
            var facilityType: Int,
            @SerializedName("hospital_user_id")
            var hospitalUserId: Int,
            @SerializedName("id")
            var id: Int,
            @SerializedName("image")
            var image: String,
            @SerializedName("image_url")
            var imageUrl: String,
            @SerializedName("lat")
            var lat: String,
            @SerializedName("long")
            var long: String,
            @SerializedName("name")
            var name: String,
            @SerializedName("nickname")
            var nickname: String,
            @SerializedName("phone")
            var phone: String,
            @SerializedName("state_name")
            var stateName: String,
            @SerializedName("street_name")
            var streetName: String,
            @SerializedName("timezone")
            var timezone: String,
            @SerializedName("updated_at")
            var updatedAt: String,
            @SerializedName("updated_by")
            var updatedBy: String,
            @SerializedName("zipcode")
            var zipcode: String,
        ) : Parcelable
    }
}