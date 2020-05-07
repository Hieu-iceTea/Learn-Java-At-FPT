<?xml version="1.0" encoding="UTF-8" ?>

<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">

    <xsl:output method="html" />

    <xsl:template match="Sales">
        <xsl:apply-templates select="Person" />
    </xsl:template>

    <xsl:template match="Person">

        <xsl:choose>
            <xsl:when test="Commision='5000'">
                <p style="color: blue; font-weight:bold; font-family: Times; margin: 8px">
                    NAME:
                    <xsl:value-of select="Name" />
                    AGE:
                    <xsl:value-of select="Age" />
                    Your Commision is
                    <xsl:value-of select="Commision" />
                    .
                </p>
            </xsl:when>

            <xsl:when test="Commision='500'">
                <p style="color: red; font-weight:bold; font-family: Times; margin: 8px">
                    NAME:
                    <xsl:value-of select="Name" />
                    AGE:
                    <xsl:value-of select="Age" />
                    Your Commision is
                    <xsl:value-of select="Commision" />
                    .
                </p>
            </xsl:when>

            <xsl:otherwise>
                <p style="color: black; font-weight:bold; font-family: Times; margin: 8px">
                    NAME:
                    <xsl:value-of select="Name" />
                    AGE:
                    <xsl:value-of select="Age" />
                    Your Commision is
                    <xsl:value-of select="Commision" />
                    .
                </p>
            </xsl:otherwise>
        </xsl:choose>


        Cách 2: dùng variable

        <xsl:variable name="color">
            <xsl:choose>
                <xsl:when test="Commision='500'">red</xsl:when>
                <xsl:when test="Commision='5000'">blue</xsl:when>
                <xsl:otherwise>black</xsl:otherwise>
            </xsl:choose>
        </xsl:variable>

        <p style="color: {$color}; font-weight:bold; font-family: Times; margin: 8px">
            NAME:
            <xsl:value-of select="Name" />
            AGE:
            <xsl:value-of select="Age" />
            Your Commision is
            <xsl:value-of select="Commision" />
            .
        </p>
        - - - - -
        
    </xsl:template>

</xsl:stylesheet>